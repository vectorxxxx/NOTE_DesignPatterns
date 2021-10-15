package com.vectorx.pattern.t2_factory.pizzastore.staticfactory.pizza;

// 奶酪披萨
public class PepperPizza extends Pizza {
    @Override
    public void prepare() {
        setName("PepperPizza");
        System.out.println(name + " preparing...");
    }
}
