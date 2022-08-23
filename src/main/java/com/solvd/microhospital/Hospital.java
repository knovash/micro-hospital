package com.solvd.microhospital;

import java.util.List;

public class Hospital {
    private String hospitalName;
    private List<Department<? extends Doctor>> departments;

    public Hospital(String hospitalName, List<Department<? extends Doctor>> departments) {
        this.hospitalName = hospitalName;
        this.departments = departments;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public List<Department<? extends Doctor>> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department<? extends Doctor>> departments) {
        this.departments = departments;
    }
}
