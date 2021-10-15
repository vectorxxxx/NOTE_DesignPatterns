package com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizzafactory;

import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza.Pizza;

public interface AbsPizzaFactory {
    Pizza createPizza(String orderType);
}
