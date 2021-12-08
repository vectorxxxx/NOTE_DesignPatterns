package com.vectorx.pattern.t11_proxy.dynamicproxy;

public class Client {
    public static void main(String[] args) {
        //创建目标对象
        ITeacherDao teacherDao = new TeacherDao();
        //通过代理工厂创建代理对象
        ITeacherDao teacherDaoProxy = (ITeacherDao) new TeacherFactory(teacherDao).newProxyInstance();
        //class jdk.proxy1.$Proxy0：内存中生成了代理对象
        System.out.println(teacherDaoProxy.getClass());
        //通过代理对象调用目标对象方法
        teacherDaoProxy.teach();
    }
}
