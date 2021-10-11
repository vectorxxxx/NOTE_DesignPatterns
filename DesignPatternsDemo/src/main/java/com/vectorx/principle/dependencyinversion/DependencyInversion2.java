package com.vectorx.principle.dependencyinversion;

import org.junit.Test;

public class DependencyInversion2 {

    @Test
    public void test() {
        Person person = new Person();
        person.receive(new Email());
        person.receive(new Weixin());
        person.receive(new ShortMessage());
    }

    /**
     * 方式2分析
     */

    interface IReceiver {
        String getInfo();
    }

    class Email implements IReceiver {
        @Override
        public String getInfo() {
            return "电子邮件信息：Hello World！";
        }
    }

    class Weixin implements IReceiver {
        @Override
        public String getInfo() {
            return "微信消息：Hello World！";
        }
    }

    class ShortMessage implements IReceiver {
        @Override
        public String getInfo() {
            return "短信信息：Hello World！";
        }
    }

    class Person {
        public void receive(IReceiver receiver) {
            System.out.println(receiver.getInfo());
        }
    }
}
