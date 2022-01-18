package com.vectorx.pattern.t22_responsibilitychain;

/**
 * 教学主任审批人
 */
public class TeachDirectorApprover extends Approver {
    public TeachDirectorApprover(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest purchaseRequest) {
        if (purchaseRequest.getPrice() <= 5000) {
            System.out.println("请求编号：" + purchaseRequest.getId() + "，处理人：" + this.name);
        } else {
            nextApprover.processRequest(purchaseRequest);
        }
    }
}
