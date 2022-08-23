package com.solvd.microhospital;

import java.math.BigDecimal;

public class ExpDoctor implements Searchable {

    @Override
    public boolean search(Doctor doctor) {
        return doctor.getPrice().compareTo(new BigDecimal(500)) == -1;
    }
}