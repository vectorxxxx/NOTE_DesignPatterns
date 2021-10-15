package com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("BJCheesePizza");
        System.out.println(name + " preparing...");
    }
}
