package com.vectorx.pattern.t4_builder.trandition;

public abstract class AbsHouse {
    protected abstract void piling();

    protected abstract void walling();

    protected abstract void capping();

    public void build() {
        piling();
        walling();
        capping();
    }
}
