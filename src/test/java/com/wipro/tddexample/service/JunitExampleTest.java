package com.wipro.tddexample.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JunitExampleTest {

    private JunitExample junitExample;

    @Before
    public void setUp() {
        junitExample = new JunitExample();
    }

    @Test
    public void testFactorialFor5() {

        assertEquals(120, junitExample.factorial(5));

    }

    @Test
    public void testFactorialFor0() {

        assertEquals(1, junitExample.factorial(0));

    }

    @Test
    public void testFactorialFor1() {

        assertEquals(1, junitExample.factorial(1));

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialForNegativeNumber() {

        junitExample.factorial(-10);

    }

    @Test(timeout = 1)
    public void testFactorialPerformance() {

        junitExample.factorial(0);

    }
}
