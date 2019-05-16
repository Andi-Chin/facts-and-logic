package com.company;


public class Gate {
    private GateType name;
    private GBWrapper inp1;
    private GBWrapper inp2;

    // constructor function for gates taking 1 input, eg: not gate
    public Gate(GateType name, GBWrapper inp1) {
        this.name = name;
        this.inp1 = inp1;
        // this will just be the default. Let's hope that it doesn't cause errors
        this.inp2 = new GBWrapper(false);

    }

    // contructor function for gates that take 2 inputs
    public Gate(GateType name, GBWrapper inp1, GBWrapper inp2) {
        this.name = name;
        this.inp1 = inp1;
        this.inp2 = inp2;
    }

    public Gate deepCopy() {
        return new Gate(this.name, this.inp1.deepCopy(), this.inp2.deepCopy());
    }


    public static boolean evaluateBool(GateType gateName, boolean inp1, boolean inp2) {
        if (gateName == GateType.AND) {
            return inp1 && inp2;
        }else if (gateName == GateType.OR) {
            return inp1 || inp2;
        }else if (gateName == GateType.NAND) {  // in this case just make inp2 false
            return !(inp1 && inp2);
        }else if (gateName == GateType.NOT) {
            return !inp1;
        }
        else {
            // FIXME jk you don't need to fix this, unless the error occurs
            System.out.println(gateName);
            throw new Error("aaaaaaaaaaaaa evalbool error");
        }
    }


    public GBWrapper evaluateGate(GBWrapper inp1, GBWrapper inp2) {

        //TODO: evalBool(inp1, evalGate(inp2.inp1, inp2.inp2)) basically

        GBWrapper evalInp1 = inp1.deepCopy();  // by default
        GBWrapper evalInp2 = inp2.deepCopy();  // by default

        if (!inp1.isGate() && !inp2.isGate()) {  // if both are boolean values
            GBWrapper breaker = new GBWrapper(Gate.evaluateBool(this.name, inp1.getBool(), inp2.getBool()));
            return breaker;
        }

        if (inp1.isGate()) {  // if inp1 is a gate

            evalInp1 = inp1.getGate().evaluateGate(inp1.getGate().getInp1(), inp1.getGate().getInp2());
            int breaker = 0;
        }
        if (inp2.isGate()) {  // if inp2 is a gate
            evalInp2 = inp2.getGate().evaluateGate(inp2.getGate().getInp1(), inp2.getGate().getInp2());
            int breaker = 0;
        }
        GBWrapper breaker = new GBWrapper(Gate.evaluateBool(this.name, evalInp1.getBool(), evalInp2.getBool()));
        return breaker;
    }


    public GateType getName() {
        return name;
    }

    public void setName(GateType name) {
        this.name = name;
    }

    public GBWrapper getInp1() {
        return inp1;
    }

    public void setInp1(GBWrapper inp1) {
        this.inp1 = inp1;
    }

    public GBWrapper getInp2() {
        return inp2;
    }

    public void setInp2(GBWrapper inp2) {
        this.inp2 = inp2;
    }

}
