package com.vectorx.pattern.t20_state.lendingplatform;

/**
 * 已发布状态类
 */
public class PublishedState extends AbstractState {
    @Override
    public void acceptOrder(Context context) {
        context.setState(new NotPaidState());
    }

    @Override
    public void acceptOrderFail(Context context) {
        context.setState(new FinishedState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.PUBLISHED.name();
    }
}
