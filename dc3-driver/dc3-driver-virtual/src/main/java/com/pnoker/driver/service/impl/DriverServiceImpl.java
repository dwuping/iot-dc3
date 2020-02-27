package com.pnoker.driver.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.pnoker.common.sdk.bean.AttributeInfo;
import com.pnoker.common.sdk.service.DriverService;
import com.pnoker.common.sdk.util.DriverUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author pnoker
 */
@Slf4j
@Service
public class DriverServiceImpl implements DriverService {

    @Override
    public void initial() {
        log.info("virtual driver");
    }

    @Override
    public String read(Map<String, AttributeInfo> driverInfo, Map<String, AttributeInfo> pointInfo) {
        String host = (String) DriverUtils.convertValue(driverInfo.get("host").getValue(), driverInfo.get("host").getType());
        Integer port = (Integer) DriverUtils.convertValue(driverInfo.get("port").getValue(), driverInfo.get("port").getType());
        String value = RandomUtil.randomString(6);
        log.info("{},{},{}", host, port, value);
        return value;
    }

    @Override
    public Boolean write(Map<String, AttributeInfo> driverInfo, Map<String, AttributeInfo> pointInfo, AttributeInfo value) {
        return false;
    }

    @Override
    public void schedule() {

    }

}
