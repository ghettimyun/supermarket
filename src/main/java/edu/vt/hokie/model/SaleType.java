package edu.vt.hokie.model;

/**
 * Enum for the different sale types
 *
 * Created by Moses Cho on 2/16/17.
 */
public enum SaleType
{
    BOGO("BOGO", "BUY ONE, GET ONE FREE"),
    THREE4TWO("342", "THREE FOR TWO"),
    BOGOHO("BOGOHO", "BUY ONE, GET ONE HALF OFF"),
    NO("NO", "NO SALES");

    private String type;
    private String text;
    SaleType(String type, String text) {
        this.type = type;
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public String getText() {
        return text;
    }

    public static SaleType fromString(String sale) {
        for (SaleType saleType : values()) {
            if (saleType.getType().equalsIgnoreCase(sale)) {
                return saleType;
            }
        }
        return SaleType.NO;
    }
}