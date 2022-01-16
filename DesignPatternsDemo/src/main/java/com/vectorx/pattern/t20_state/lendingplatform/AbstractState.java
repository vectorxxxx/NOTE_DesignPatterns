package com.vectorx.pattern.t20_state.lendingplatform;

/**
 * 抽象状态类，默认实现
 */
public abstract class AbstractState implements State {
    private static final RuntimeException EXCEPTION = new RuntimeException("操作流程有误");

    @Override
    public void electronicAudit(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void electronicAuditFail(Context context) {
        throw EXCEPTION;

    }

    @Override
    public void releasePricing(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void acceptOrder(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void acceptOrderFail(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void payMoney(Context context) {
        throw EXCEPTION;
    }

    @Override
    public void feedback(Context context) {
        throw EXCEPTION;
    }
}
