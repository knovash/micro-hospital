package com.solvd.microhospital;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("test genric");

        Human hum1 = new Human("Petr");
        hum1.setName("Ivan");
        System.out.println(hum1.getName());

        Doctor doc1 = new Doctor("Ivan", "dent");
        doc1.setName("Igor");
        doc1.setSpec("dent");
        System.out.println(doc1.getName());
        System.out.println(doc1.getSpec());
        doc1.makeDiagnosis(); // доступен только метод общий врачей

        Surgeon sur1 = new Surgeon("Ivan", "sur", "cut leg");
        Surgeon sur2 = new Surgeon("Petr", "sur", "cut hand");
        Dentist den1 = new Dentist("Olga", "dent", "tooth 9");
        Dentist den2 = new Dentist("Zina", "dent", "tooth 3");
        Dentist den3 = new Dentist("Max", "dent", "tooth 3");
        Dentist den4 = new Dentist("Serg", "dent", "tooth 3");

        sur1.setPrice(new BigDecimal(100));
        sur2.setPrice(new BigDecimal(100));
        den1.setPrice(new BigDecimal(1500));
        den2.setPrice(new BigDecimal(200));
        den3.setPrice(new BigDecimal(1200));
        den4.setPrice(new BigDecimal(400));


        sur1.setGender(Human.Gender.MALE);
        sur2.setGender(Human.Gender.FEMALE);
        sur1.setGender(Human.Gender.MALE);
        sur1.setGender(Human.Gender.MALE);

        sur1.setOperation("cut head");
        den1.setTooth("tooth 7");
        sur1.doOperate(); // метод хирурга
        den1.doPullout(); // метод зубного
        sur1.makeDiagnosis(); // общий метод врачей
        den1.makeDiagnosis(); // общий метод врачей
        sur2.doOperate();
        den2.doPullout();
        sur2.makeDiagnosis();
        den2.makeDiagnosis();

        List<Dentist> dentists = new ArrayList<>(); // лист зубных
        dentists.add(den1);
        dentists.add(den2);
        dentists.add(den3);
        dentists.add(den4);
//        dentists.add(sur1); // добавляются только зубные
        dentists.get(0).makeDiagnosis();
        dentists.get(0).doPullout(); // метод зубных

        List<Surgeon> surgeons = new ArrayList<>(); // лист хирургов
        surgeons.add(sur1); // добавляются только хирурги
        surgeons.add(sur2);
        surgeons.get(0).makeDiagnosis();
        surgeons.get(0).doOperate(); // метод хирургов

        List<Doctor> docs = new ArrayList<>(); // лист врачей
        docs.add(sur1); // добавляются любые врачи (хирурги, зубные)
        docs.add(den1); // добавляются любые врачи (хирурги, зубные)
        docs.get(0).makeDiagnosis(); // доступны только методы врача

        // DepartmentDental extends Department<Dentist> объект отдела зубных
        DepartmentDental departmentDental = new DepartmentDental("dep dental", dentists);
        // DepartmentSurgery extends Department<Surgeon> объект отдела хирургов
        DepartmentSurgery departmentSurgery = new DepartmentSurgery("dep surgery", surgeons);
        DepartmentSurgery departmentSurgery2 = new DepartmentSurgery("dep dental2", surgeons);

        departmentDental.setDoctors(dentists); // просетываются только зубные
        departmentSurgery.setDoctors(surgeons); // просетываются только хирурги
        departmentSurgery2.setDoctors(surgeons);

        departmentDental.getDoctors().get(0).doPullout();
        departmentSurgery.getDoctors().get(0).doOperate();
        departmentSurgery.getDoctors().get(0).makeDiagnosis();
        departmentSurgery2.getDoctors().get(0).makeDiagnosis();
        departmentSurgery2.getDoctors().get(0).doOperate();

        List<Department<Surgeon>> depList1 = new ArrayList<>(); // список отделов только хирургов
        depList1.add(departmentSurgery);
        depList1.add(departmentSurgery2);
        depList1.get(0).getDoctors().get(0).doOperate(); // метод хирургов

        List<Department<Dentist>> depList2 = new ArrayList<>(); // список отделов только зубных
        depList2.add(departmentDental);
        depList2.add(departmentDental);
        depList2.get(0).getDoctors().get(0).doPullout(); // метод зубных

        List<Department<? extends Doctor>> departments = new ArrayList<>(); // список отделов разных врачей
//        List<Department<?>> departments = new ArrayList<>();

        departments.add(departmentDental);
        departments.add(departmentSurgery);
        departments.add(departmentSurgery2);

        Map<String, Department<? extends Doctor>> depMap = new HashMap<>();
        depMap.put("dnt", departmentDental);
        depMap.put("sur", departmentSurgery);


        System.out.println("DEPARTMENT 0 ---------");
        System.out.println(departments.get(0).getDescription());
        System.out.println(departments.get(0).getDoctors().get(0).getSpec());
        System.out.println(departments.get(0).getDoctors().get(0).getName());
        System.out.println(departments.get(0).getDoctors().get(0).getClass());
        departments.get(0).getDoctors().get(0).makeDiagnosis(); // метод только врачей
//        departments.get(0).getDoctors().get(0).


        System.out.println("DEPARTMENT 1 ---------");
        System.out.println(departments.get(1).getDescription());
        System.out.println(departments.get(1).getDoctors().get(0).getSpec());
        System.out.println(departments.get(1).getDoctors().get(0).getName());
        System.out.println(departments.get(1).getDoctors().get(0).getClass());

        System.out.println("DEPARTMENT 2 ---------");
        departments.get(2).setDescription("dep 2 xxx");
        System.out.println(departments.get(2).getDescription());

        Hospital hospital = new Hospital("Hospital", departments);

        hospital.getDepartments().get(0).getDoctors().get(0).setName("xxx");
        System.out.println(hospital.getDepartments().get(0).getDoctors().get(0).getName());
        System.out.println(hospital.getDepartments().get(0).getDoctors().get(0).getSpec());


        System.out.println("getSearchDoctorsNames ExpDoctor");
        System.out.println(HospitalUtils.getSearchDocNames(dentists, new ExpDoctor()));
        System.out.println("getSearchDoctorsNames LuxDoctor");
        System.out.println(HospitalUtils.getSearchDocNames(dentists, new LuxDoctor()));


//        System.out.println("getSearchDoctorsNames Searchable");
//        System.out.println(HospitalUtils.getSearchDocNames(dentists, new Searchable() {
//            @Override
//            public boolean search(Doctor doctor) {
//                return doctor.getPrice().compareTo(new BigDecimal(500)) == 1;
//            }
//        }));

        System.out.println("Lambda hospital");
        System.out.println(HospitalUtils.getSearchDocNames(dentists,
                (Doctor doctor) -> doctor.getPrice().compareTo(new BigDecimal(500)) == 1));

        System.out.println("Stream test");
        for (Department item : hospital.getDepartments()
        ) {
            System.out.println("xxxx " + item.getDescription());

        }


        List<String> newList = hospital.getDepartments().stream()
//                .filter(department -> department.getDescription().contains("s"))
                .map(department -> department.getDescription())
                .peek((p) -> System.out.println("peek " + p))
                .collect(Collectors.toList());

        hospital.getDepartments().stream()
                .filter(department -> department.getDescription().contains("s"))
                .map(department -> department.getDescription())
                .peek((p) -> System.out.println("peek2 " + p))
                .collect(Collectors.toList());

        hospital.getDepartments().stream()
                .map(department -> department.getDescription())
                .forEach((p) -> System.out.println("peek3 " + p));

        System.out.println("-------");
        hospital.getDepartments().stream()
                .peek((p) -> System.out.println("description: " + p.getDescription()))
                .flatMap(department -> department.getDoctors().stream())
                .peek((p) -> System.out.println(" spec: " + p.getSpec() + " " + p.getName()))
                .forEach((p) -> System.out.println(" print: " + p));
        System.out.println("Stream test Map");


        for (Map.Entry<String, Department<? extends Doctor>> item : depMap.entrySet()) {
            System.out.println("map: " + item.getKey() + " " + item.getValue().getDescription());
        }

        depMap.entrySet().stream()
                .peek((d) -> System.out.println("stream desc: " + d.getValue() + " " + d.getKey()))
                .forEach((p) -> System.out.println(" print: " + p));
    }


}