package com.company;

public class Main {

    public static void main(String[] args) {
        Gate gate3 = new Gate("and", new GBWrapper(false), new GBWrapper(false));
        Gate gate2 = new Gate("or", new GBWrapper(true), new GBWrapper(false));
        Gate gate1 = new Gate("nand", new GBWrapper(gate2), new GBWrapper(gate3));



        GBWrapper result = gate1.evaluateGate(gate1.getInp1(), gate1.getInp2());
        System.out.println(result.getBool());



    }

}
