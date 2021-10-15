package com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.order;

import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizzafactory.AbsPizzaFactory;
import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizzafactory.BJPizzaFactory;
import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizzafactory.LDPizzaFactory;

public class PizzaStore {
    public static void main(String[] args) {
        AbsPizzaFactory pizzaFactory = null;
        String type = "London";
        if ("London".equals(type)) {
            pizzaFactory = new LDPizzaFactory();
        } else if ("Beijing".equals(type)) {
            pizzaFactory = new BJPizzaFactory();
        }
        OrderPizza orderPizza = new OrderPizza(pizzaFactory);
        orderPizza.orderPizza();
    }
}
