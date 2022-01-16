package com.vectorx.pattern.t20_state.lendingplatform;

public class Client {
    public static void main(String[] args) {
        Context context = new Context();
        context.electronicAudit(context);
        context.releasePricing(context);
        context.acceptOrder(context);
        context.payMoney(context);

        context.electronicAuditFail(context);
        context.acceptOrderFail(context);
        //当前状态：AUDITED
        //当前状态：PUBLISHED
        //当前状态：NOT_PAID
        //当前状态：PAID
        //Exception in thread "main" java.lang.RuntimeException: 操作流程有误
        //	at com.vectorx.pattern.t20_state.lendingplatform.AbstractState.<clinit>(AbstractState.java:7)
        //	at com.vectorx.pattern.t20_state.lendingplatform.Client.main(Client.java:5)
    }
}
