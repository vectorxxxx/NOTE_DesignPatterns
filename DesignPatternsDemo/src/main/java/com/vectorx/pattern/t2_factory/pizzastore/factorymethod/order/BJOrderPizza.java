package com.vectorx.pattern.t2_factory.pizzastore.factorymethod.order;

import com.vectorx.pattern.t2_factory.pizzastore.factorymethod.pizza.BJCheesePizza;
import com.vectorx.pattern.t2_factory.pizzastore.factorymethod.pizza.BJPepperPizza;
import com.vectorx.pattern.t2_factory.pizzastore.factorymethod.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {
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
