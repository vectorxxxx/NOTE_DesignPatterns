package com.vectorx.pattern_advance.t2_factory.vegetable.v3.shed;

import com.vectorx.pattern_advance.t2_factory.vegetable.v3.vegetable.Waxgourd;

/**
 * 冬瓜棚子
 */
public class WaxgourdShed implements VegetableShed {
    @Override
    public Waxgourd plantVegetable() {
        return new Waxgourd();
    }
}
