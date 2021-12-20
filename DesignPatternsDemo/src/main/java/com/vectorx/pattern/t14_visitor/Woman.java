package com.vectorx.pattern.t14_visitor;

/**
 * 具体元素
 */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
