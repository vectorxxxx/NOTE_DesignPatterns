package com.vectorx.pattern.t20_state.lendingplatform;

/**
 * 未付款状态类
 */
public class PaidState extends AbstractState {
    @Override
    public void feedback(Context context) {
        context.setState(new FinishedState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.PAID.name();
    }
}
