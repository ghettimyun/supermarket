package edu.vt.hokie.model;

/**
 * Calculator class for BOGO
 *
 * Created by Moses Cho on 2/16/17.
 */
public class BOGOCalculator implements Calculator {
    public double calculate(int quantity, double price) {
        int main = quantity / 2;
        int remainder = quantity % 2;

        return (main + remainder) * price;
    }
}
