package com.vectorx.pattern.t22_responsibilitychain;

public class Client {
    public static void main(String[] args) {
        //创建一个请求
        PurchaseRequest purchaseRequest = new PurchaseRequest(1, 31000.0f);

        //创建相关的审批人
        TeachDirectorApprover teachDirectorApprover = new TeachDirectorApprover("童主任");
        DepartmentHeadApprover departmentHeadApprover = new DepartmentHeadApprover("王院长");
        ViceChancellorApprover viceChancellorApprover = new ViceChancellorApprover("钱副校长");
        ChancellorApprover chancellorApprover = new ChancellorApprover("郑校长");

        //设置后继者（处理人形成环形）
        teachDirectorApprover.setNextApprover(departmentHeadApprover);
        departmentHeadApprover.setNextApprover(viceChancellorApprover);
        viceChancellorApprover.setNextApprover(chancellorApprover);
        chancellorApprover.setNextApprover(teachDirectorApprover);

        //发起一个请求
        teachDirectorApprover.processRequest(purchaseRequest); //请求编号：1，处理人：郑校长
    }
}
