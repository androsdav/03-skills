package com.adidyk.service;

import com.adidyk.annotation.LogExecutionTime;
import org.springframework.stereotype.Service;

/**
 * Class ThreadService.
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 10.04.2020.
 * @version 1.0.
 */
@Service
public class ThreadService {

    /**
     * threadSleep - thread sleep.
     * @throws InterruptedException - interrupted exception.
     */
    @LogExecutionTime
    public void threadSleep() throws InterruptedException {
        Thread.sleep(1000);
    }

}