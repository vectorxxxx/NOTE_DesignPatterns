package com.vectorx.pattern.t20_state.lendingplatform;

/**
 * 上下文环境类
 */
public class Context extends AbstractState {
    private State state;

    public Context() {
        state = new GeneratedState();
    }

    @Override
    public void electronicAudit(Context context) {
        state.electronicAudit(context);
        getCurrentState();
    }

    @Override
    public void electronicAuditFail(Context context) {
        state.electronicAuditFail(context);
        getCurrentState();
    }

    @Override
    public void releasePricing(Context context) {
        state.releasePricing(context);
        getCurrentState();
    }

    @Override
    public void acceptOrder(Context context) {
        state.acceptOrder(context);
        getCurrentState();
    }

    @Override
    public void acceptOrderFail(Context context) {
        state.acceptOrderFail(context);
        getCurrentState();
    }

    @Override
    public void payMoney(Context context) {
        state.payMoney(context);
        getCurrentState();
    }

    @Override
    public void feedback(Context context) {
        state.feedback(context);
        getCurrentState();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String getCurrentState() {
        System.out.println("当前状态：" + state.getCurrentState());
        return state.getCurrentState();
    }
}
