package com.adidyk.service;

import org.springframework.stereotype.Service;

/**
 * Class CalculateService..
 * @author Didyk Andrey (androsdav@gmail.com).
 * @since 10.04.2020.
 * @version 1.0.
 */
@Service
public class CalculateService {

    /**
     * addition - addition two value.
     * @param first - first value.
     * @param second - second value.
     * @return - returns result of addition.
     */
    public double addition(double first, double second) {
        return first + second;
    }

    /**
     * subtraction - subtraction two value.
     * @param first - first value.
     * @param second - second value.
     * @return - returns result of addition.
     */
    public double subtraction(double first, double second) {
        return first - second;
    }

    /**
     * multiplication - multiplication two value.
     * @param first - first value.
     * @param second - second value.
     * @return - returns result of addition.
     */
    public double multiplication(double first, double second) {
        return first * second;
    }

    /**
     * division - division two value.
     * @param first - first value.
     * @param second - second value.
     * @return - returns result of addition.
     */
    public double division(double first, double second) {
        return  first / second;
    }

}