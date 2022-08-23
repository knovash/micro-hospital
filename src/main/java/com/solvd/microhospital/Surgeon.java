package com.solvd.microhospital;

public class Surgeon extends Doctor {
    private String operation;

    public Surgeon(String name, String spec, String operation) {
        super(name, spec);
        this.operation = operation;
    }

    public void doOperate() {
        System.out.println(getName() + " " + getSpec() +" operate " + operation);
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
