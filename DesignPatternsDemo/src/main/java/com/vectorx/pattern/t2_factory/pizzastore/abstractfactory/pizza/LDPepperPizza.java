package com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza;

public class LDPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("LDPepperPizza");
        System.out.println(name + " preparing...");
    }
}
