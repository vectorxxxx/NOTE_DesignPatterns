package com.vectorx.pattern.t11_proxy.staticproxy;

/**
 * 代理对象
 */
public class TeacherDaoProxy implements ITeacherDao {
    private ITeacherDao iteacherDao;

    public TeacherDaoProxy(ITeacherDao iteacherDao) {
        this.iteacherDao = iteacherDao;
    }

    @Override
    public void teach() {
        System.out.println("准备授课...");
        iteacherDao.teach();
        System.out.println("结束授课...");
    }
}
