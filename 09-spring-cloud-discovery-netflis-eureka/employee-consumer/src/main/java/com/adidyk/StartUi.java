package com.adidyk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;

/**
 * Class StartUi.
 */
@SpringBootApplication
public class StartUi {

    /**
     * main - main.
     * @param args - arg.
     */
    public static void main(String [] args) throws IOException {
        ApplicationContext ctx = SpringApplication.run(StartUi.class, args);
        ConsumerControllerClient consumerControllerClient=ctx.getBean(ConsumerControllerClient.class);
        System.out.println(consumerControllerClient);
        consumerControllerClient.getEmployee();
    }

    /**
     * consumerControllerClient - consumer controller client.
     * @return - gets consumer controller client.
     */
    @Bean
    public  ConsumerControllerClient  consumerControllerClient() {
        return  new ConsumerControllerClient(getRestTemplate());
    }

    /**
     * getRestTemplate - gets link to object class RestTemplate.
     * @return - returns link to object of class RestTemplate.
     */
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}