package com.solvd.microhospital;

public class Dentist extends Doctor{
    private String tooth;

    public Dentist(String name, String spec, String tooth) {
        super(name, spec);
        this.tooth = tooth;
    }

    public void doPullout() {
        System.out.println(getName() + " " + getSpec() +" pullout " + tooth);
    }

    public String getTooth() {
        return tooth;
    }

    public void setTooth(String tooth) {
        this.tooth = tooth;
    }
}
