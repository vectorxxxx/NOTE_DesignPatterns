package com.vectorx.pattern.t14_visitor;

/**
 * 具体访问者
 */
public class Wait extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男生给了待定");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女生给了待定");
    }
}
