package com.company;

// a wrapper class for gate and boolean
public class GBWrapper {
    private Gate gate;
    private boolean bool;
    private boolean isGate;

    public GBWrapper(Gate gate) {
        this.gate = gate;
        this.isGate = true;
    }
    public GBWrapper(boolean bool) {
        this.bool = bool;
        this.isGate = false;
    }

    public GBWrapper deepCopy() {
        if (this.isGate) {
            return new GBWrapper(this.gate);
        }else {
            return new GBWrapper(this.bool);
        }
    }

    public boolean isGate() {
        return this.isGate;
    }
    public Gate getGate() {
        return this.gate;
    }
    public boolean getBool() {
        return this.bool;
    }

    public Object getValue() {
        if (this.isGate) {
            return this.gate;
        }else {
            return this.bool;
        }
    }

}