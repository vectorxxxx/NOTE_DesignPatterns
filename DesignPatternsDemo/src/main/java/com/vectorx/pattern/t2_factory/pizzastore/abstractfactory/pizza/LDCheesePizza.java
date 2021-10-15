package com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza;

public class LDCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("LDCheesePizza");
        System.out.println(name + " preparing...");
    }
}
