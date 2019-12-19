/*
 * Copyright 2019 Pnoker. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pnoker.device.group.service.wia.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.pnoker.device.group.dao.wia.WiaVariableMapper;
import com.pnoker.device.group.model.wia.WiaVariable;
import com.pnoker.device.group.service.wia.WiaVariableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>WiaDevice 接口实现
 *
 * @author : pnoker
 * @email : pnokers@icloud.com
 */
@Service
public class WiaVariableServiceImpl implements WiaVariableService {
    @Resource
    private WiaVariableMapper wiaVariableMapper;

    @Override
    public List<WiaVariable> list(Wrapper<WiaVariable> wrapper) {
        return wiaVariableMapper.selectList(wrapper);
    }
}
