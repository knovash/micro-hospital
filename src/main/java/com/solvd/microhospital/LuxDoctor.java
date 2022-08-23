package com.solvd.microhospital;

import java.math.BigDecimal;

public class LuxDoctor implements Searchable {

    @Override
    public boolean search(Doctor doctor) {
        return doctor.getPrice().compareTo(new BigDecimal(500)) == 1;
    }
}