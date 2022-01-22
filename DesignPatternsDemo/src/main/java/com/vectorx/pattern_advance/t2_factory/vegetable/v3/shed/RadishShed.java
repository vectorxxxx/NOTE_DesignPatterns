package com.vectorx.pattern_advance.t2_factory.vegetable.v3.shed;

import com.vectorx.pattern_advance.t2_factory.vegetable.v3.vegetable.Radish;

/**
 * 萝卜棚子
 */
public class RadishShed implements VegetableShed {
    @Override
    public Radish plantVegetable() {
        return new Radish();
    }
}
