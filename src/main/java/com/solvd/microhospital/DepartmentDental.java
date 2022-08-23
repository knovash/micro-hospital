package com.solvd.microhospital;

import java.util.List;

public class DepartmentDental extends Department<Dentist> {

    public DepartmentDental(String description, List<Dentist> doctors) {
        super(description, doctors);
    }
}

