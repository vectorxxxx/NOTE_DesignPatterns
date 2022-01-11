package com.vectorx.pattern.t17_mediator;

/**
 * 窗帘
 */
public class Curtain extends Colleague {
    public Curtain(Mediator mediator) {
        super(mediator);
        this.getMediator().registerColleague(this);
    }

    /**
     * 拉起窗帘
     */
    public void upCurtain() {
        System.out.println(">>>拉起窗帘...");
        sendMsg(1);
        try {
            //模拟拉起窗帘耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拉下窗帘
     */
    public void downCurtain() {
        System.out.println(">>>拉下窗帘...");
        sendMsg(0);
        try {
            //模拟拉下窗帘耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
