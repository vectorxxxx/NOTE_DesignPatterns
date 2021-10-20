package com.vectorx.pattern.t6_bridge.client;

import com.vectorx.pattern.t6_bridge.abstraction.FlipPhone;
import com.vectorx.pattern.t6_bridge.abstraction.Phone;
import com.vectorx.pattern.t6_bridge.abstraction.UprightPhone;
import com.vectorx.pattern.t6_bridge.implementor.Huawei;
import com.vectorx.pattern.t6_bridge.implementor.Xiaomi;
import com.vectorx.pattern.t6_bridge.implementor.iPhone;

public class Client {
    public static void main(String[] args) {
        Phone phone = new FlipPhone(new Huawei());
        phone.open();
        phone.call();
        phone.close();

        System.out.println("======================");
        phone = new FlipPhone(new Xiaomi());
        phone.open();
        phone.call();
        phone.close();

        System.out.println("======================");
        phone = new UprightPhone(new iPhone());
        phone.open();
        phone.call();
        phone.close();
    }
}
