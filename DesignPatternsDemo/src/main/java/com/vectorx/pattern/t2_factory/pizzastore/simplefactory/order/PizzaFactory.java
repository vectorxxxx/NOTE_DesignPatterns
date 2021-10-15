package com.vectorx.pattern.t2_factory.pizzastore.simplefactory.order;

import com.vectorx.pattern.t2_factory.pizzastore.simplefactory.pizza.CheesePizza;
import com.vectorx.pattern.t2_factory.pizzastore.simplefactory.pizza.GreekPizza;
import com.vectorx.pattern.t2_factory.pizzastore.simplefactory.pizza.PepperPizza;
import com.vectorx.pattern.t2_factory.pizzastore.simplefactory.pizza.Pizza;

public class PizzaFactory {
    public Pizza createPizza(String orderType) {
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
