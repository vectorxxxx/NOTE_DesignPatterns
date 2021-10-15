package com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizzafactory;

import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza.LDCheesePizza;
import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza.LDPepperPizza;
import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza.Pizza;

public class LDPizzaFactory implements AbsPizzaFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "cheese":
                pizza = new LDCheesePizza();
                break;
            case "pepper":
                pizza = new LDPepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
