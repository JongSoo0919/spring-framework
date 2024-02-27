package org.example.customer;

import java.util.Objects;

public class Cook {
    private final String name;
    private final int price;

    public Cook(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.getPrice();

    }
    public Cook(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name + price);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Cook)){
            return false;
        }
        Cook cook = (Cook)obj;
        return this.hashCode() == cook.hashCode();
    }
}
