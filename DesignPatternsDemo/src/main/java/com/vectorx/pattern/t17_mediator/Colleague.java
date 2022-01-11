package com.vectorx.pattern.t17_mediator;

/**
 * 抽象同事类
 */
public abstract class Colleague {
    private Mediator mediator;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public Mediator getMediator() {
        return this.mediator;
    }

    public void sendMsg(Integer state) {
        this.getMediator().getMsg(state, this.getClass().getSimpleName());
    }
}
