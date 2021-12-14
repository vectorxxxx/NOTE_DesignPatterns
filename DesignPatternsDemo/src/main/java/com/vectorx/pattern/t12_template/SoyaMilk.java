package com.vectorx.pattern.t12_template;

/**
 * 抽象类
 */
public abstract class SoyaMilk {
    /**
     * 模板方法，定义为final禁止覆写
     */
    public final void make() {
        System.out.println(">>>>>>豆浆制作开始<<<<<<");
        useSoyBean();
        if (customAddIngredients()) {
            addIngredients();
        }
        soak();
        mash();
        System.out.println(">>>>>>豆浆制作结束<<<<<<");
    }

    protected void useSoyBean() {
        System.out.println("Step1. 选用上好的黄豆.");
    }

    protected abstract void addIngredients();

    protected void soak() {
        System.out.println("Step3. 对黄豆和配料进行水洗浸泡.");
    }

    protected void mash() {
        System.out.println("Step4. 将充分浸泡过的黄豆和配料放入豆浆机中，开始打豆浆.");
    }

    protected Boolean customAddIngredients() {
        return true;
    }
}
