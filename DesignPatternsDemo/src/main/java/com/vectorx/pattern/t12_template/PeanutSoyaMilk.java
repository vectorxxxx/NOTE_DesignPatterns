package com.vectorx.pattern.t12_template;

/**
 * 花生豆浆
 */
public class PeanutSoyaMilk extends SoyaMilk {
    public PeanutSoyaMilk() {
        System.out.println("============花生豆浆============");
    }

    @Override
    protected void addIngredients() {
        System.out.println("Step2. 加入上好的花生.");
    }
}
