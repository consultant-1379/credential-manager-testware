package com.ericsson.nms.security.taf.test.operators;

public interface CalculatorOperator {
    String getName();

    int sum(int x, int y);

    int subtraction(int x, int y);

    int divide(int x, int y);

    int multiply(int x, int y);
}
