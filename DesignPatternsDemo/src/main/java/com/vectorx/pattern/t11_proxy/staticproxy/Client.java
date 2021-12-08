package com.vectorx.pattern.t11_proxy.staticproxy;

public class Client {
    public static void main(String[] args) {
        //创建被代理对象
        TeacherDao teacherDao = new TeacherDao();
        //创建代理对象，聚合被代理对象
        TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
        //通过代理对象，调用被代理对象的方法
        teacherDaoProxy.teach();
    }
}
