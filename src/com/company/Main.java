package com.company;

public class Main {

    public static void main(String[] args) {
        // true
        Gate gate3 = new Gate(GateType.OR, new GBWrapper(true), new GBWrapper(false));
        // false
        Gate gate2 = new Gate(GateType.NOT, new GBWrapper(gate3));
        // false
        Gate gate1 = new Gate(GateType.AND, new GBWrapper(gate2), new GBWrapper(true));

        GBWrapper result = gate1.evaluateGate(gate1.getInp1(), gate1.getInp2());

        System.out.println(result.getBool());



    }

}
