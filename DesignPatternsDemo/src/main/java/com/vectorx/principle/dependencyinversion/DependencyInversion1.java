package com.vectorx.principle.dependencyinversion;

import org.junit.Test;

public class DependencyInversion1 {

    @Test
    public void test() {
        Person person = new Person();
        person.receive(new Email());
    }

    /**
     * 方式1分析
     * 1.简单，比较容易想到
     * 2.如果我们获取的对象是微信，短信等等，则新增类，同时 Peron也要增加相应的接收方法
     * 3.解决思路：
     * 引入一个抽象的接口IReceiver，表示接收者，这样Person类与接口IReceiver发生依赖
     * 因为Email，Weixin等等属于接收的范围，他们各自实现IReceiver接口就ok，这样我们就符号依赖倒转原则
     */
    class Email {
        public String getInfo() {
            return "电子邮件信息：Hello World！";
        }
    }

    class Person {
        public void receive(Email email) {
            System.out.println(email.getInfo());
        }
    }
}
