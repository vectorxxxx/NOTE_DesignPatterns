package com.vectorx.pattern.t20_state.lendingplatform;

/**
 * 状态接口
 */
public interface State {
    /**
     * 电审
     *
     * @param context
     */
    void electronicAudit(Context context);

    /**
     * 电审失败
     *
     * @param context
     */
    void electronicAuditFail(Context context);

    /**
     * 定价发布
     *
     * @param context
     */
    void releasePricing(Context context);

    /**
     * 接单
     *
     * @param context
     */
    void acceptOrder(Context context);

    /**
     * 接单失败
     *
     * @param context
     */
    void acceptOrderFail(Context context);

    /**
     * 付款
     *
     * @param context
     */
    void payMoney(Context context);

    /**
     * 反馈【下款 或 拒贷】
     *
     * @param context
     */
    void feedback(Context context);

    String getCurrentState();
}
