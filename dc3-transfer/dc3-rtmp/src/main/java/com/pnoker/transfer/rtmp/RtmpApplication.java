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

package com.pnoker.transfer.rtmp;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>Rtmp 视频转码服务启动入口
 *
 * @author : pnoker
 * @email : pnokers@icloud.com
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = {
        "com.pnoker.api.center.dbs.rtmp.*"
})
@ComponentScan(basePackages = {
        "com.pnoker.api.center.dbs.rtmp",
        "com.pnoker.transfer.rtmp"
})
public class RtmpApplication {

    public static void main(String[] args) {
        SpringApplication.run(RtmpApplication.class, args);
    }
}

