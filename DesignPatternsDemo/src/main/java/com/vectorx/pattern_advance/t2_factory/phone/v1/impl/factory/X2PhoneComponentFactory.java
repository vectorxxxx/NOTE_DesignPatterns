package com.vectorx.pattern_advance.t2_factory.phone.v1.impl.factory;

import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Battery;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Camera;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Chip;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.component.Screen;
import com.vectorx.pattern_advance.t2_factory.phone.v1.api.factory.PhoneComponentFactory;
import com.vectorx.pattern_advance.t2_factory.phone.v1.impl.component.battery.LithiumIonBattery;
import com.vectorx.pattern_advance.t2_factory.phone.v1.impl.component.camera.DuoCamera;
import com.vectorx.pattern_advance.t2_factory.phone.v1.impl.component.chip.SnapdragonChip;
import com.vectorx.pattern_advance.t2_factory.phone.v1.impl.component.screen.IpsScreen;

/**
 * X2
 */
public class X2PhoneComponentFactory extends PhoneComponentFactory {
    @Override
    public Chip productChip() {
        return new SnapdragonChip();
    }

    @Override
    public Camera productCamera() {
        return new DuoCamera();
    }

    @Override
    public Screen productScreen() {
        return new IpsScreen();
    }

    @Override
    public Battery productBattery() {
        return new LithiumIonBattery();
    }
}
