package com.vectorx.pattern.t7_decorator.concretecomponent;

import com.vectorx.pattern.t7_decorator.component.Drink;

public class Coffee extends Drink {

    @Override
    public Float cost() {
        return super.getPrice();
    }
}
