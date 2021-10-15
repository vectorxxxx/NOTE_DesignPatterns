package com.vectorx.pattern.t2_factory.pizzastore.staticfactory.pizza;

// 奶酪披萨
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("CheesePizza");
        System.out.println(name + " preparing...");
    }
}
