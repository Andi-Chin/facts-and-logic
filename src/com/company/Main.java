package com.company;

public class Main {

    public static void main(String[] args) {

        Gate gate1 = new Gate("nand", new GBWrapper(true), new GBWrapper(true));



        GBWrapper result = gate1.evaluateGate(gate1.getInp1(), gate1.getInp2());
        System.out.println(result.getBool());



    }

}
