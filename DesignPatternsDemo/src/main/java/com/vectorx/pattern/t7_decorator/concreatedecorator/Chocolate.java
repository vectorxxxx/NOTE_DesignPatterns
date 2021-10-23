package com.vectorx.pattern.t7_decorator.concreatedecorator;

import com.vectorx.pattern.t7_decorator.component.Drink;
import com.vectorx.pattern.t7_decorator.decorator.Decorator;

public class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
        setDesc("巧克力");
        setPrice(5.0f);
    }
}
