package com.vectorx.pattern.t11_proxy.staticproxy;

/**
 * 被代理对象
 */
public class TeacherDao implements ITeacherDao {
    @Override
    public void teach() {
        System.out.println("老师授课中...");
    }
}
