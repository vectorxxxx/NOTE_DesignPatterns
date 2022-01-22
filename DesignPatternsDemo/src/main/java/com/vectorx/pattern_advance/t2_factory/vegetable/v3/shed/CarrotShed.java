package com.vectorx.pattern_advance.t2_factory.vegetable.v3.shed;

import com.vectorx.pattern_advance.t2_factory.vegetable.v3.vegetable.Carrot;

/**
 * 胡萝卜棚子
 */
public class CarrotShed implements VegetableShed {
    @Override
    public Carrot plantVegetable() {
        return new Carrot();
    }
}
