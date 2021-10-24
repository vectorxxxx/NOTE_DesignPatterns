package com.vectorx.pattern.t8_composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {
    List<OrganizationComponent> organizationComponentList = new ArrayList<>();

    public College(String name) {
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
        System.out.println("=============" + getName() + "=============");
        for (OrganizationComponent organizationComponent : organizationComponentList) {
            organizationComponent.print();
        }
    }
}
