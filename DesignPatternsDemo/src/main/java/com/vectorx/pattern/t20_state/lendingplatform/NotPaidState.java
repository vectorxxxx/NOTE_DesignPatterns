package com.vectorx.pattern.t20_state.lendingplatform;

/**
 * 未付款状态类
 */
public class NotPaidState extends AbstractState {
    @Override
    public void payMoney(Context context) {
        context.setState(new PaidState());
    }

    @Override
    public void feedback(Context context) {
        context.setState(new FinishedState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.NOT_PAID.name();
    }
}
