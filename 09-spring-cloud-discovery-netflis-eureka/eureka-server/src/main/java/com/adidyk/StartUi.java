package com.adidyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Class StartUi.
 */
@SpringBootApplication
@EnableEurekaServer
public class StartUi {

    public static void main(String [] arg) {
        SpringApplication.run(StartUi.class);
    }

}