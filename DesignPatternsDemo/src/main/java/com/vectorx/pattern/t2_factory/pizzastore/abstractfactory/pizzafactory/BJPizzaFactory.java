package com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizzafactory;

import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza.BJCheesePizza;
import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza.BJPepperPizza;
import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza.Pizza;

public class BJPizzaFactory implements AbsPizzaFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        switch (orderType) {
            case "cheese":
                pizza = new BJCheesePizza();
                break;
            case "pepper":
                pizza = new BJPepperPizza();
                break;
            default:
                break;
        }
        return pizza;
    }
}
