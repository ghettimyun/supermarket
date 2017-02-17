package edu.vt.hokie.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lxc686 on 2/16/17.
 */
public class CalculatorFactory {
    Map<SaleType, Calculator> calculators;

    /**
     * Constructor
     */
    public CalculatorFactory() {
        calculators = new HashMap<SaleType, Calculator>();
        calculators.put(SaleType.NO, new DefaultCalculator());
        calculators.put(SaleType.BOGO, new BOGOCalculator());
        calculators.put(SaleType.THREE4TWO, new ThreeForTwoCalculator());
        calculators.put(SaleType.BOGOHO, new BOGOHOCalculator());
    }

    /**
     * Returns a calculator of the desired type
     *
     * @param type The sale type
     * @return The desired calculator
     */
    public Calculator getCalculator(SaleType type) {
        return calculators.get(type);
    }
}
