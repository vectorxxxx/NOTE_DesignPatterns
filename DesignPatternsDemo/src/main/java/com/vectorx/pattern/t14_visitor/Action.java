package com.vectorx.pattern.t14_visitor;

/**
 * 抽象访问者
 */
public abstract class Action {
    public abstract void getManResult(Man man);

    public abstract void getWomanResult(Woman woman);
}
