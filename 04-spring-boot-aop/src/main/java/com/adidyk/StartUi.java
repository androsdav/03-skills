package com.adidyk;

import com.adidyk.service.CalculateService;
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
     * @param calculateService - calculate service.
     */
    private CalculateService calculateService;

    /**
     * StartUi - constructor.
     * @param storageService - composer.
     */
    @Autowired
    public StartUi(StorageService storageService, CalculateService calculateService) {
        this.storageService = storageService;
        this.calculateService = calculateService;
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

        System.out.println();
        System.out.println("logAfterAllNameMethodInStorageService: ");
        this.storageService.add(10);
        this.storageService.add(11);
        this.storageService.add(12);
        this.storageService.add(13);
        this.storageService.add(14);
        this.storageService.remove(4);
        this.storageService.get(1);
        this.storageService.getAll();
        this.storageService.size();
        this.storageService.equals(5);
        this.storageService.hashCode();
        this.storageService.toString();

        System.out.println();
        System.out.println("logAfterAllNameMethodInPackageService: ");
        this.storageService.add(10);
        this.storageService.add(11);
        this.storageService.add(12);
        this.storageService.add(13);
        this.storageService.add(14);
        this.storageService.remove(4);
        this.storageService.get(1);
        this.storageService.getAll();
        this.storageService.size();
        this.storageService.equals(5);
        this.storageService.hashCode();
        this.storageService.toString();
        this.calculateService.addition(1, 2);
        this.calculateService.subtraction(3, 4);
        this.calculateService.multiplication(4, 6);
        this.calculateService.division((double)54, (double)42);

        System.out.println();
        System.out.println("logAfterCalculateServiceMethodAddition: ");
        this.calculateService.addition(1, 2);
        this.calculateService.subtraction(3, 4);
        this.calculateService.multiplication(4, 6);
        this.calculateService.division((double)54, (double)0);
        this.calculateService.concatWord("hello", "world");
        this.calculateService.concatStringWithDouble("hello", (double) 120);


        /*
        for (Integer item : this.storageService.getAll()) {
            System.out.println("item: " + item);
        }
        */
    }

}