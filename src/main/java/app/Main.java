/*
 * @ (#) $NAME.java         2/26/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package app;

import entity.Address;
import entity.Date;
import entity.Patient;
import entity.Test;
import handle.ObjectModelAPI;
import handle.StreamingAPI;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 2/26/2024
 */
public class Main {
    public static void main(String[] args) {
//        List<Patient> painters = ObjectModelAPI.readFromFile("data/patients.json");
//
//        System.out.println(painters);
//
//        System.out.println("=====================================");
//
//        for (Patient p : painters) {
//            System.out.println(p);
//        }


        List<Patient> patients = new ArrayList<>();

        Patient p1 = new Patient("P01", "John", "Smith", "Male", "-B", 1999, new Address("ABC", "XYZ", "NY", "AL"), new ArrayList<>(List.of("1234", "1234")), new ArrayList<>(List.of(new Test(new Date(1, 2, 2021), "High", 123, "Low", 150.0))));
        Patient p2 = new Patient(
                "P01",
                "John",
                "Smith",
                "Male",
                "-B",
                1999,
                new Address("ABC", "XYZ", "NY", "AL"),
                List.of("1234", "1234"),
                List.of(new Test(new Date(1, 2, 2021), "High", 123, "Low", 150.0))
        );
        Patient p3 = new Patient(
                "P01",
                "John",
                "Smith",
                "Male",
                "-B",
                1999,
                new Address("ABC", "XYZ", "NY", "AL"),
                List.of("1234", "1234"),
                List.of(new Test(new Date(1, 2, 2021), "High", 123, "Low", 150.0))
        );

        patients.add(p1);
        patients.add(p2);
        patients.add(p3);

        StreamingAPI.toFile(patients, "data/patientsss.json");
//
//        ObjectModelAPI.toFile(patients, "data/patientss.json");

//        List<Patient> p = StreamingAPI.readFromFiles("data/patients.json");
//        System.out.println(p);




    }
}

