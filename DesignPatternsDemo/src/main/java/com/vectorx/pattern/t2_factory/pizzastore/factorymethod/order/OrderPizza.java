package com.vectorx.pattern.t2_factory.pizzastore.factorymethod.order;

import com.vectorx.pattern.t2_factory.pizzastore.factorymethod.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class OrderPizza {

    public void orderPizza() {
        Pizza pizza = null;
        do {
            pizza = createPizza(getType());
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

    public abstract Pizza createPizza(String orderType);

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
