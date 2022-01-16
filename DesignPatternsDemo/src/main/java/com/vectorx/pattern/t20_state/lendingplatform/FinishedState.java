package com.vectorx.pattern.t20_state.lendingplatform;

/**
 * 未付款状态类
 */
public class FinishedState extends AbstractState {
    @Override
    public String getCurrentState() {
        return StateEnum.FINISHED.name();
    }
}
