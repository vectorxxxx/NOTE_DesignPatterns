package com.vectorx.pattern.t7_decorator.client;

import com.vectorx.pattern.t7_decorator.component.Drink;
import com.vectorx.pattern.t7_decorator.concreatedecorator.Chocolate;
import com.vectorx.pattern.t7_decorator.concreatedecorator.Milk;
import com.vectorx.pattern.t7_decorator.concretecomponent.Espresso;

public class CoffeeBar {
    public static void main(String[] args) {
        Drink drink = new Espresso();
        System.out.println("意大利浓咖：" + drink.cost() + "美元"); // 意大利浓咖：30.0美元

        drink = new Milk(drink);
        System.out.println("意大利浓咖 + 1份牛奶：" + drink.cost() + "美元"); // 意大利浓咖 + 1份牛奶：33.0美元

        drink = new Chocolate(drink);
        System.out.println("意大利浓咖 + 1份牛奶 + 1份巧克力：" + drink.cost() + "美元"); // 意大利浓咖 + 1份牛奶 + 1份巧克力：38.0美元

        drink = new Chocolate(drink);
        System.out.println("意大利浓咖 + 1份牛奶 + 2份巧克力：" + drink.cost() + "美元"); // 意大利浓咖 + 1份牛奶 + 2份巧克力：43.0美元
    }
}
