package com.vectorx.pattern_advance.t2_factory.phone.v1.impl.factory;

import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Battery;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Camera;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Chip;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Screen;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.factory.PhoneComponentFactory;
import com.vectorx.pattern_advance.t2_factory.phone.v1.impl.component.battery.NickelCadmiumBattery;
import com.vectorx.pattern_advance.t2_factory.phone.v1.impl.component.camera.SingleCamera;
import com.vectorx.pattern_advance.t2_factory.phone.v1.impl.component.chip.KylinChip;
import com.vectorx.pattern_advance.t2_factory.phone.v1.impl.component.screen.OledScreen;

/**
 * X1
 */
public class X1PhoneComponentFactory extends PhoneComponentFactory {
    @Override
    public Chip productChip() {
        return new KylinChip();
    }

    @Override
    public Camera productCamera() {
        return new SingleCamera();
    }

    @Override
    public Screen productScreen() {
        return new OledScreen();
    }

    @Override
    public Battery productBattery() {
        return new NickelCadmiumBattery();
    }
}
