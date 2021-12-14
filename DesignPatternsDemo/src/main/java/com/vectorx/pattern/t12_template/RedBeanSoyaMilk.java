package com.vectorx.pattern.t12_template;

/**
 * 红豆豆浆
 */
public class RedBeanSoyaMilk extends SoyaMilk {
    public RedBeanSoyaMilk() {
        System.out.println("============红豆豆浆============");
    }

    @Override
    protected void addIngredients() {
        System.out.println("Step2. 加入上好的红豆.");
    }
}
