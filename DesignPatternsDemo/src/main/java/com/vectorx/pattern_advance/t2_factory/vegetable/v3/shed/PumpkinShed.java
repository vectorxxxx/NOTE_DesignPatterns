package com.vectorx.pattern_advance.t2_factory.vegetable.v3.shed;

import com.vectorx.pattern_advance.t2_factory.vegetable.v3.vegetable.Pumpkin;

/**
 * 南瓜棚子
 */
public class PumpkinShed implements VegetableShed {
    @Override
    public Pumpkin plantVegetable() {
        return new Pumpkin();
    }
}
