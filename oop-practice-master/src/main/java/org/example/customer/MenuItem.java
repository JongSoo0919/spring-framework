package org.example.customer;

import java.util.Objects;

public class MenuItem {
    private final String name;
    private final int price;

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name + price);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof MenuItem)){
            return false;
        }
        MenuItem cook = (MenuItem) obj;
        return this.hashCode() == cook.hashCode();
    }
}
