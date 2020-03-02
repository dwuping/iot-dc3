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

package com.pnoker.center.data.service.pool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author pnoker
 */
@Slf4j
@Component
public class ThreadPool {
    public static int CORE_POOL_SIZE = 4;
    public static int MAX_POOL_SIZE = 32;
    public static int KEEP_ALIVE_TIME = 10;

    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    /**
     * 线程池
     */
    public ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(MAX_POOL_SIZE * 2),
            r -> {
                Thread thread = new Thread(r, "dc3-thread-" + mThreadNum.getAndIncrement());
                log.info("{} has been created", thread.getName());
                return thread;
            }, (r, e) -> log.error("{} rejected,completedTaskCount:{}", r.toString(), e.getCompletedTaskCount()));
}
