package com.solvd.microhospital;

import java.util.List;

public class HospitalUtils {

    public static int getSearchDocNames(List<Dentist> doctors, Searchable s) {

        int result = 0;
        for (Doctor doctor : doctors) {
            if (s.search(doctor))
            {
                System.out.println("Search: " + doctor.getName() + " " + doctor.getPrice());
                result++;
            }
        }
        return result;
    }
}
