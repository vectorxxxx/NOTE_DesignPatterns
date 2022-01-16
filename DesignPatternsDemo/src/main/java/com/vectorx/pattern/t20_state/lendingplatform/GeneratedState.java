package com.vectorx.pattern.t20_state.lendingplatform;

/**
 * 订单生成状态类
 */
public class GeneratedState extends AbstractState {
    @Override
    public void electronicAudit(Context context) {
        context.setState(new AuditedState());
    }

    @Override
    public void electronicAuditFail(Context context) {
        context.setState(new FinishedState());
    }

    @Override
    public String getCurrentState() {
        return StateEnum.GENERATED.name();
    }
}
