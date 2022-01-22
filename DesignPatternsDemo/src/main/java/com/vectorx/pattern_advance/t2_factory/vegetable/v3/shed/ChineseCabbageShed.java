package com.vectorx.pattern_advance.t2_factory.vegetable.v3.shed;

import com.vectorx.pattern_advance.t2_factory.vegetable.v3.vegetable.ChineseCabbage;

/**
 * 大白菜棚子
 */
public class ChineseCabbageShed implements VegetableShed {
    @Override
    public ChineseCabbage plantVegetable() {
        return new ChineseCabbage();
    }
}
