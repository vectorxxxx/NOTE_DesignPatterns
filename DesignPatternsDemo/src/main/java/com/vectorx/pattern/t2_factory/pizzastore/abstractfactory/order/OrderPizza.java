package com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.order;


import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizza.Pizza;
import com.vectorx.pattern.t2_factory.pizzastore.abstractfactory.pizzafactory.AbsPizzaFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    private AbsPizzaFactory absPizzaFactory;

    public OrderPizza(AbsPizzaFactory absPizzaFactory) {
        this.absPizzaFactory = absPizzaFactory;
    }

    public void orderPizza() {
        Pizza pizza = null;
        do {
            if (absPizzaFactory != null) {
                pizza = absPizzaFactory.createPizza(getType());
            }
            if (pizza == null) {
                System.out.println("Failed to Order Pizza");
            } else {
                pizza.prepare();
                pizza.bake();
                pizza.cut();
                pizza.box();
            }
        } while (true);
    }

    private String getType() {
        System.out.println("请输入披萨类型：");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
