package com.wipro.tddexample.service;

public class JunitExample {

    public int factorial(int number) {

        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be less than zero");
        } else if (number < 2) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }

    }
}
