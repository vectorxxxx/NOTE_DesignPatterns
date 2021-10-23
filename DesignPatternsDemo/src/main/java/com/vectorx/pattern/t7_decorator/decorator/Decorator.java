package com.vectorx.pattern.t7_decorator.decorator;

import com.vectorx.pattern.t7_decorator.component.Drink;

//装饰者
public class Decorator extends Drink {
    private Drink drink;

    public Decorator(Drink drink) {
        this.drink = drink;
    }

    @Override
    public Float cost() {
        return super.getPrice() + drink.cost();
    }
}
