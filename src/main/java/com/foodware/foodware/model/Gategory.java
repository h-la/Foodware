package com.foodware.foodware.model;

public enum Gategory {
    FRIDGE("jääkaappi"),
    FREEZER("pakastin"),
    ROOM("huone");

    public final String label;

    private Gategory(String label) {
        this.label = label;
    }
}
