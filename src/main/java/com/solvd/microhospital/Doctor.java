package com.solvd.microhospital;

import java.math.BigDecimal;

public class Doctor extends Human implements Searchable{
    private String spec;
    private BigDecimal price;

    public Doctor(String name, String spec) {
        super(name);
        this.spec = spec;
    }

    public void makeDiagnosis(){
        System.out.println(getName() + " " + spec + " Doctor make diagnosis");
    }
    @Override
    public boolean search(Doctor doctor) {
        return doctor.getPrice().compareTo(new BigDecimal(500)) == -1;
    }

    public enum Spec {
        MALE, FEMALE
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
