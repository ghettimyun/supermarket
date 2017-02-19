package edu.vt.hokie.main;

import edu.vt.hokie.model.SaleType;
import edu.vt.hokie.model.ShoppingCart;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 * Created by lxc686 on 2/17/17.
 */
public class ShoppingCartTest {
    ShoppingCart            cart;
    List<String>            itemList;
    Map<String, Integer>    quantityMap;
    Map<String, Double>     priceMap;
    Map<String, SaleType>   saleMap;

    @Before
    public void setUpStreams() {
        cart = new ShoppingCart();
        cart.initializeItem("APPLE", 1);
        cart.initializeItem("ORANGE", 2);
        cart.initializeItem("BANANA", 1);
        cart.initializeItem("PEACH", 1);

        itemList = cart.getItems();
        quantityMap = cart.getQuantityMap();
        priceMap = cart.getPriceMap();
        saleMap = cart.getSaleMap();
    }

    @Test
    public void testInitItem() {
        cart.initializeItem("APPLE", 2);
        assertEquals(priceMap.get("APPLE"), (Double)1.0);
    }

    @Test
    public void testApplySale() {
        cart.applySale("APPLE", "BOGO");
        assertEquals(saleMap.get("APPLE"), SaleType.BOGO);

        cart.applySale("NOTHING", "BOGO");
        assertFalse(saleMap.containsKey("NOTHING"));

        cart.applySale("APPLE", "NOTHING");
        assertEquals(saleMap.get("APPLE"), SaleType.NO);
    }

    @Test
    public void testAddItem() {
        cart.addItem("APPLE", 1);
        assertEquals(quantityMap.get("APPLE"), (Integer)1);

        cart.addItem("NOTHING", 1);
        assertFalse(quantityMap.containsKey("NOTHING"));
    }

    @Test
    public void testRemoveItem() {
        cart.removeItem("APPLE", 1);
        assertEquals(quantityMap.get("APPLE"), (Integer)0);

        cart.removeItem("NOTHING", 1);
        assertFalse(quantityMap.containsKey("NOTHING"));

        quantityMap.put("APPLE", 1);
        cart.removeItem("APPLE", 3);
        assertEquals(quantityMap.get("APPLE"), (Integer)0);
    }

    @Test
    public void testCalculate() {
        quantityMap.put("APPLE", 25);
        quantityMap.put("ORANGE", 33);
        quantityMap.put("BANANA", 43);
        quantityMap.put("PEACH", 13);

        saleMap.put("APPLE", SaleType.BOGO);
        saleMap.put("ORANGE", SaleType.BOGOHO);
        saleMap.put("BANANA", SaleType.THREE4TWO);

        assertEquals((Double)cart.printCartAndSubtotal(), (Double)105.0);
    }
}
