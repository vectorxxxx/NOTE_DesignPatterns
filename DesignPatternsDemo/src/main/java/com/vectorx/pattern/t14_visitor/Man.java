package com.vectorx.pattern.t14_visitor;

/**
 * 具体元素
 */
public class Man extends Person {
    @Override
    public void accept(Action action) {
        action.getManResult(this);
    }
}
