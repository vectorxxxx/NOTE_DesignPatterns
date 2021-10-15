package com.vectorx.pattern.t2_factory.pizzastore.factorymethod.order;


import com.vectorx.pattern.t2_factory.pizzastore.factorymethod.pizza.LDCheesePizza;
import com.vectorx.pattern.t2_factory.pizzastore.factorymethod.pizza.LDPepperPizza;
import com.vectorx.pattern.t2_factory.pizzastore.factorymethod.pizza.Pizza;

public class LDOrderPizza extends OrderPizza {
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
