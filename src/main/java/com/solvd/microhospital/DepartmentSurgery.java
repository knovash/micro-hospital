package com.solvd.microhospital;

import java.util.List;

public class DepartmentSurgery extends Department<Surgeon> {

    public DepartmentSurgery(String description, List<Surgeon> doctors) {
        super(description, doctors);
    }
}
