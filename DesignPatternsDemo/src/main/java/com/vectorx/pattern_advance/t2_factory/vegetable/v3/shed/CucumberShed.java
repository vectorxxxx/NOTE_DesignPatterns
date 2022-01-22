package com.vectorx.pattern_advance.t2_factory.vegetable.v3.shed;

import com.vectorx.pattern_advance.t2_factory.vegetable.v3.vegetable.Cucumber;

/**
 * 黄瓜棚子
 */
public class CucumberShed implements VegetableShed {
    @Override
    public Cucumber plantVegetable() {
        return new Cucumber();
    }
}
