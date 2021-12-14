package com.vectorx.pattern.t12_template;

/**
 * 纯豆浆
 */
public class PureSoyaMilk extends SoyaMilk {
    public PureSoyaMilk() {
        System.out.println("============纯豆浆============");
    }

    @Override
    protected void addIngredients() {
        // 空实现即可
    }

    @Override
    protected Boolean customAddIngredients() {
        return false;
    }
}
