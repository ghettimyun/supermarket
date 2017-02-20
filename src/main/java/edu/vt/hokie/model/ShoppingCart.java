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
    private List<String>            items;

    /**
     * Constructor
     */
    public ShoppingCart() {
        priceMap = new HashMap<String, Double>();
        saleMap = new HashMap<String, SaleType>();
        quantityMap = new HashMap<String, Integer>();
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
        // TODO Implement
    }

    /**
     * Removes item from the cart
     *
     * @param item The item
     * @param quantity The amount to remove
     */
    public void removeItem(String item, Integer quantity) {
        // TODO Implement
    }

    /**
     * Prints out what is in the cart and the total price
     */
    public void printCartAndSubtotal() {
        // TODO Implement
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
     * Getter for price
     *
     * @return Map containing prices
     */
    public Map<String, Double> getPriceMap() {
        return priceMap;
    }

    /**
     * Getter for sales
     *
     * @return Map containing sales
     */
    public Map<String, SaleType> getSaleMap() {
        return saleMap;
    }

    /**
     * Getter for quantities
     *
     * @return Map containing quantities
     */
    public Map<String, Integer> getQuantityMap() {
        return quantityMap;
    }

    /**
     * Getter for items
     *
     * @return List containing items
     */
    public List<String> getItems() {
        return items;
    }
}
