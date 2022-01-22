package com.vectorx.pattern_advance.t2_factory.vegetable.v3.shed;

import com.vectorx.pattern_advance.t2_factory.vegetable.v3.vegetable.GreenPeper;

/**
 * 青椒棚子
 */
public class GreenPeperShed implements VegetableShed {
    @Override
    public GreenPeper plantVegetable() {
        return new GreenPeper();
    }
}
