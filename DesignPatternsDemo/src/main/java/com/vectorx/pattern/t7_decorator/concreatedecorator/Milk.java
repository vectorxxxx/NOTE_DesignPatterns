package com.vectorx.pattern.t7_decorator.concreatedecorator;

import com.vectorx.pattern.t7_decorator.component.Drink;
import com.vectorx.pattern.t7_decorator.decorator.Decorator;

public class Milk extends Decorator {
    public Milk(Drink drink) {
        super(drink);
        setDesc("牛奶");
        setPrice(3.0f);
    }
}
