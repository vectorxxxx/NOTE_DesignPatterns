package com.vectorx.pattern.t2_factory.pizzastore.factorymethod.pizza;

public class BJPepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("BJPepperPizza");
        System.out.println(name + " preparing...");
    }
}
