package com.solvd.microhospital;

import java.util.List;

public class Department<D extends Doctor> {
    private String description;
    private List<D> doctors;

    public Department(String description, List<D> doctors) {
        this.description = description;
        this.doctors = doctors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<D> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<D> doctors) {
        this.doctors = doctors;
    }
}
