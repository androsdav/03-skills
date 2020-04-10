package com.adidyk;

import com.adidyk.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Class StartUi.
 */
@SpringBootApplication
@EnableAspectJAutoProxy
public class StartUi implements CommandLineRunner {

    /**
     * @param composer - composer.
     */
    private StorageService storageService;

    /**
     * StartUi - constructor.
     * @param storageService - composer.
     */
    @Autowired
    public StartUi(StorageService storageService) {
        this.storageService = storageService;
    }

    /**
     * main - main.
     * @param arg - arg.
     */
    public  static void main(String[] arg) {
        SpringApplication.run(StartUi.class, arg);
    }

    /**
     * run - run project.
     * @param arg - arg.
     */
    @Override
    public void run(String ... arg) {
        //this.storageService.add(10);
        //this.storageService.add(11);
        //this.storageService.add(12);
        //this.storageService.add(13);
        this.storageService.add(14);
        for (Integer item : this.storageService.getAll()) {
            System.out.println("item: " + item);
        }
    }

}