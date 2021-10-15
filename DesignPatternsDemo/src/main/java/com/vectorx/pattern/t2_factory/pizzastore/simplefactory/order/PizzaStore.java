package com.vectorx.pattern.t2_factory.pizzastore.simplefactory.order;

public class PizzaStore {
    public static void main(String[] args) {
        OrderPizza orderPizza = new OrderPizza(new PizzaFactory());
    }
}
