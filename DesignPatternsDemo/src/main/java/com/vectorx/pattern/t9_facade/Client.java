package com.vectorx.pattern.t9_facade;


public class Client {
    public static void main(String[] args) throws InterruptedException {
        HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
        System.out.println("===========家庭影院初始化============");
        homeTheaterFacade.ready();
        System.out.println("===========家庭影院沉浸式播放============");
        homeTheaterFacade.play();
        Thread.sleep(1000);
        System.out.println("===========家庭影院暂停============");
        homeTheaterFacade.pause();
        Thread.sleep(1000);
        System.out.println("===========家庭影院沉浸式播放============");
        homeTheaterFacade.play();
        Thread.sleep(1000);
        System.out.println("===========家庭影院结束============");
        homeTheaterFacade.end();
    }
}
