package edu.vt.hokie.model;

/**
 * Calculator for 3for2
 * Created by Moses Cho on 2/16/17.
 */
public class ThreeForTwoCalculator implements Calculator {
    public double calculate(int quantity, double price) {
        int main = (quantity / 3) * 2;
        int remainder = quantity % 3;

        return (main + remainder) * price;
    }
}
