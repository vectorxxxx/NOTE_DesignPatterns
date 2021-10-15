package com.vectorx.pattern.t2_factory.pizzastore.staticfactory.order;

import com.vectorx.pattern.t2_factory.pizzastore.staticfactory.pizza.CheesePizza;
import com.vectorx.pattern.t2_factory.pizzastore.staticfactory.pizza.GreekPizza;
import com.vectorx.pattern.t2_factory.pizzastore.staticfactory.pizza.PepperPizza;
import com.vectorx.pattern.t2_factory.pizzastore.staticfactory.pizza.Pizza;

public class PizzaFactory {
    public static Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "cheese":
                pizza = new CheesePizza();
                break;
            case "greek":
                pizza = new GreekPizza();
                break;
            case "pepper":
                pizza = new PepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
