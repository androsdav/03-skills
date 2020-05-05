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
    public Double addition(double first, double second) {
        return first + second;
    }

    /**
     * subtraction - subtraction two value.
     * @param first - first value.
     * @param second - second value.
     * @return - returns result of addition.
     */
    public Double subtraction(double first, double second) {
        return first - second;
    }

    /**
     * multiplication - multiplication two value.
     * @param first - first value.
     * @param second - second value.
     * @return - returns result of addition.
     */
    public Double multiplication(double first, double second) {
        return first * second;
    }

    /**
     * division - division two value.
     * @param first - first value.
     * @param second - second value.
     * @return - returns result of addition.
     */
    public Double division(Double first, Double second) {
        return  first / second;
    }

    /**
     * concatWord - concat two words.
     * @param first - first word.
     * @param second - second word.
     * @return - returns concat two word.
     */
    public String concatWord(String first, String second) {
        return first + second;
    }

    /**
     * concatFirstWithDouble - concat first with double.
     * @param first - first param.
     * @param second - second param.
     * @return - returns result concat first with double.
     */
    public String concatStringWithDouble(String first, Double second) {
        return first + second;
    }

}