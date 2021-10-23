package com.vectorx.pattern.t7_decorator.concreatedecorator;

import com.vectorx.pattern.t7_decorator.component.Drink;
import com.vectorx.pattern.t7_decorator.decorator.Decorator;

public class Soy extends Decorator {
    public Soy(Drink drink) {
        super(drink);
        setDesc("豆浆");
        setPrice(4.0f);
    }
}
