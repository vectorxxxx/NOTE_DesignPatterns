package com.vectorx.pattern.t22_responsibilitychain;

/**
 * 副校长审批人
 */
public class ChancellorApprover extends Approver {
    public ChancellorApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() > 30000) {
            System.out.println("请求编号：" + purchaseRequest.getId() + "，处理人：" + this.name);
        } else {
            nextApprover.processRequest(purchaseRequest);
        }
    }
}
