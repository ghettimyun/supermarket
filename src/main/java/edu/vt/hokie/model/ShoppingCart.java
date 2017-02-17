package edu.vt.hokie.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The shopping cart object
 *
 * Created by Moses Cho on 2/15/17.
 */
public class ShoppingCart {
    private Map<String, Double>     priceMap;
    private Map<String, SaleType>   saleMap;
    private Map<String, Integer>    quantityMap;
    private CalculatorFactory       factory;
    private List<String>            items;

    /**
     * Constructor
     */
    public ShoppingCart() {
        priceMap = new HashMap<String, Double>();
        saleMap = new HashMap<String, SaleType>();
        quantityMap = new HashMap<String, Integer>();
        factory = new CalculatorFactory();
        items = new ArrayList<String>();
    }

    /**
     * Adds item to the system
     *
     * @param item The item
     * @param price The price
     */
    public void initializeItem(String item, double price) {
        if (items.contains(item)) {
            System.out.println("Sorry, " + item + " already exists in the database.");
        }
        else {
            items.add(item);
            priceMap.put(item, price);
            saleMap.put(item, SaleType.NO);
            quantityMap.put(item, 0);
        }
    }

    /**
     * Adds a sale to an item in the system
     *
     * @param item The item
     * @param sale The sale to apply
     */
    public void applySale(String item, String sale) {
        if (items.contains(item)) {
            saleMap.put(item, SaleType.fromString(sale));
        }
        else {
            System.out.println("Sorry, " + item + " does not exist in the database.");
        }
    }

    /**
     * Adds item to the cart
     *
     * @param item The item
     * @param quantity The amount to add
     */
    public void addItem(String item, Integer quantity) {
        if (items.contains(item)) {
            quantityMap.put(item, quantityMap.get(item) + quantity);
        }
        else {
            System.out.println("Sorry, " + item + " does not exist in the database.");
        }
    }

    /**
     * Removes item from the cart
     *
     * @param item The item
     * @param quantity The amount to remove
     */
    public void removeItem(String item, Integer quantity) {
        if (items.contains(item)) {
            if (quantityMap.get(item) == 0) {
                System.out.println("No " + item + "S in your cart.");
                return;
            }

            Integer total = quantityMap.get(item) - quantity;

            if (total <= 0) {
                total = 0;
                System.out.println("All " + item + "S removed.");
            }

            quantityMap.put(item, total);
        }
        else {
            System.out.println("Sorry, " + item + " does not exist in the database.");
        }
    }

    /**
     * Prints out what is in the cart and the total price
     */
    public void printCartAndSubtotal() {
        double total = 0;

        for (String item : items) {
            double price = calculate(item);
            total += price;
            System.out.printf("%-4d%-20s$%.2f\n", quantityMap.get(item), item, price);
        }

        System.out.println("\n-----------");
        System.out.printf("%-24s$%.2f\n", "SUBTOTAL:", total);
    }

    /**
     * Prints out each item in the system and its price
     */
    public void prices() {
        for (String item : items) {
            System.out.printf("%-24s$%.2f\n", item, priceMap.get(item));
        }
    }

    /**
     * Prints out each item in the system and any sales
     */
    public void sales() {
        for (String item : items) {
            System.out.printf("%-24s%25s\n", item, saleMap.get(item).getText());
        }
    }

    /**
     * Calculates the total price of an item
     *
     * @param item The item
     * @return The total price of an item
     */
    private double calculate(String item) {
        Calculator calculator = factory.getCalculator(saleMap.get(item));

        return calculator.calculate(quantityMap.get(item), priceMap.get(item));
    }
}
