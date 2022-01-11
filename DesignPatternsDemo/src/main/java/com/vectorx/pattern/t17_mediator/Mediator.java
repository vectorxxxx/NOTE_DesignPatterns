package com.vectorx.pattern.t17_mediator;

/**
 * 抽象中介者
 */
public abstract class Mediator {
    public abstract void registerColleague(Colleague colleague);

    public abstract void getMsg(Integer state, String name);

    public abstract void sendMsg();
}
