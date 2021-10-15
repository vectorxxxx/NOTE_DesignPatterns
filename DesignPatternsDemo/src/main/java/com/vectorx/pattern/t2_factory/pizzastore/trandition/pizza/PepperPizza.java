package com.vectorx.pattern.t2_factory.pizzastore.trandition.pizza;

// 奶酪披萨
public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("CheesePizza");
        System.out.println(name + " preparing...");
    }
}
