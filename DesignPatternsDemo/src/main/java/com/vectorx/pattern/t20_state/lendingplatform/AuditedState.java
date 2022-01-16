package com.vectorx.pattern.t20_state.lendingplatform;

/**
 * 已审核状态类
 */
public class AuditedState extends AbstractState {
    @Override
    public void releasePricing(Context context) {
        context.setState(new PublishedState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.AUDITED.name();
    }
}
