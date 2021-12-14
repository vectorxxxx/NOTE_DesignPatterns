package com.vectorx.pattern.t12_template;

/**
 * 芝麻豆浆
 */
public class SesameSoyaMilk extends SoyaMilk {
    public SesameSoyaMilk() {
        System.out.println("============芝麻豆浆============");
    }

    @Override
    protected void addIngredients() {
        System.out.println("Step2. 加入上好的芝麻.");
    }
}
