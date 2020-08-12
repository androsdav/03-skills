package com.adidyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Class StartUi.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer {

    /**
     * main - main.
     * @param args - args.
     */
    public static void main(String [] args) {
        SpringApplication.run(EurekaServer.class);
    }

}