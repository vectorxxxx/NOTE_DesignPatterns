package com.vectorx.pattern.t17_mediator;

/**
 * 电视机
 */
public class TV extends Colleague {
    public TV(Mediator mediator) {
        super(mediator);
        this.getMediator().registerColleague(this);
    }

    /**
     * 打开电视
     */
    public void openTV() {
        System.out.println(">>>打开电视...");
        sendMsg(1);
    }

    /**
     * 关闭电视
     */
    public void closeTV() {
        System.out.println(">>>关闭电视...");
        sendMsg(0);
    }

    /**
     * 切换频道
     */
    public void switchChannel(Integer state) {
        System.out.println(">>>切换频道：" + state);
        sendMsg(state);
        try {
            //模拟看电视耗时
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
