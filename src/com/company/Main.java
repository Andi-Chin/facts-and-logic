package com.company;

public class Main {

    public static void main(String[] args) {

        Gate gate2 = new Gate(GateType.OR, new GBWrapper(false), new GBWrapper(true));
        Gate gate1 = new Gate(GateType.NAND, new GBWrapper(gate2), new GBWrapper(false));

        GBWrapper result = gate1.evaluateGate(gate1.getInp1(), gate1.getInp2());

        System.out.println(result.getBool());



    }

}
