package com.vectorx.pattern.t14_visitor;

/**
 * 抽象元素
 */
public abstract class Person {
    public abstract void accept(Action action);
}
