package com.vectorx.pattern_advance.t2_factory.phone.v1.api.factory;

import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Battery;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Camera;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Chip;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Screen;

public abstract class PhoneComponentFactory {
    public abstract Chip productChip();

    public abstract Camera productCamera();

    public abstract Screen productScreen();

    public abstract Battery productBattery();
}
