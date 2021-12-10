package com.vectorx.pattern.t11_proxy.cglibproxy;

/**
 * 被代理对象
 */
public class TeacherDao {
    public String teach() {
        System.out.println("老师授课中...");
        return "Good";
    }
}
