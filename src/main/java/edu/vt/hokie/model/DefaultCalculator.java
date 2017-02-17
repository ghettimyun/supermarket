package edu.vt.hokie.model;

/**
 * The default calculator
 *
 * Created by Moses Cho on 2/16/17.
 */
public class DefaultCalculator implements Calculator {
    public double calculate(int quantity, double price) {
        return quantity * price;
    }
}
