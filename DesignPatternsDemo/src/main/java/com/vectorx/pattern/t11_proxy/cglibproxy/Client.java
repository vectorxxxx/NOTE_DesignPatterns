package com.vectorx.pattern.t11_proxy.cglibproxy;

public class Client {
    public static void main(String[] args) {
        //创建目标对象
        TeacherDao teacherDao = new TeacherDao();
        //通过代理工厂创建代理对象
        TeacherDao proxyInstance = (TeacherDao) new ProxyFactory(teacherDao).getProxyInstance();
        //通过代理对象调用目标对象方法
        String retVal = proxyInstance.teach();
        System.out.println("retVal=" + retVal);
    }
}
