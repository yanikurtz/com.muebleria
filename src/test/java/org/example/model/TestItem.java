package org.example.model;

import model.Item;

public enum TestItem {
    LIGHT_WOOD(1, "Light wood"),
    DARK_WOOD(2, "Dark wood"),
    RED_PAINT(3, "Red paint"),
    BLUE_PAINT(4, "Blue paint"),
    NAILS(5, "Nails");

    public final Integer id;
    public final String name;

    TestItem(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item build(Integer quantity) {
        return new Item(this.id, this.name, quantity);
    }
}
