package com.vectorx.pattern.t2_factory.pizzastore.trandition.order;

import com.vectorx.pattern.t2_factory.pizzastore.trandition.pizza.CheesePizza;
import com.vectorx.pattern.t2_factory.pizzastore.trandition.pizza.GreekPizza;
import com.vectorx.pattern.t2_factory.pizzastore.trandition.pizza.PepperPizza;
import com.vectorx.pattern.t2_factory.pizzastore.trandition.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {
    public OrderPizza() {
        Pizza pizza = null;
        String orderType;
        do {
            orderType = getType();
            if ("cheese".equals(orderType)) {
                pizza = new CheesePizza();
            } else if ("greek".equals(orderType)) {
                pizza = new GreekPizza();
            } else if ("pepper".equals(orderType)) {
                pizza = new PepperPizza();
            } else {
                System.out.println("输入类型错误，程序退出");
                break;
            }
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
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
