package com.vectorx.pattern.t8_composite;

import java.util.ArrayList;
import java.util.List;

public class University extends OrganizationComponent {
    List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public University(String name) {
        super(name);
    }

    @Override
    public void add(OrganizationComponent organizationComponent) {
        organizationComponentList.add(organizationComponent);
    }

    @Override
    public void remove(OrganizationComponent organizationComponent) {
        organizationComponent.remove(organizationComponent);
    }

    @Override
    public void print() {
        for (OrganizationComponent organizationComponent : organizationComponentList) {
            organizationComponent.print();
        }
    }
}
