package com.adidyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Class StartUi.
 */
@SpringBootApplication
@EnableDiscoveryClient
public class StartUi {

    /**
     * main - main method.
     * @param args - args.
     */
    public static void main(String [] args) {
        SpringApplication.run(StartUi.class, args);
    }

}