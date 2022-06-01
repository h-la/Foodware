package com.foodware.foodware.model;

public enum QuantityUnit {
    KG("kg"),
    G("g"),
    LITRE("l");

    public final String label;

    private QuantityUnit(String label) {
        this.label = label;
    }
}
