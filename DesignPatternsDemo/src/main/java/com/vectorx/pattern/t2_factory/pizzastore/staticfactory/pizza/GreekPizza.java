package com.vectorx.pattern.t2_factory.pizzastore.staticfactory.pizza;

//希腊风味披萨
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        setName("GreekPizza");
        System.out.println(name + " preparing...");
    }
}
