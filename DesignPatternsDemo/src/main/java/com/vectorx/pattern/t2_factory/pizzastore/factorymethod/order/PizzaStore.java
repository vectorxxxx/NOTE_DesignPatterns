package com.vectorx.pattern.t2_factory.pizzastore.factorymethod.order;

public class PizzaStore {
    public static void main(String[] args) {
        OrderPizza orderPizza = null;
        String type = "London";
        if ("London".equals(type)) {
            orderPizza = new LDOrderPizza();
        } else if ("Beijing".equals(type)) {
            orderPizza = new BJOrderPizza();
        }

        if (orderPizza != null) {
            orderPizza.orderPizza();
        }
    }
}
