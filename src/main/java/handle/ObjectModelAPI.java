/*
 * @ (#) $NAME.java         2/26/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package handle;

import entity.Address;
import entity.Date;
import entity.Patient;
import entity.Test;
import jakarta.json.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 2/26/2024
 */
public class ObjectModelAPI {
    public static List<Patient> readFromFile(String fileName) {
        List<Patient> p = new ArrayList<>();
        try (
                JsonReader reader = Json.createReader(new FileReader(fileName));

        ) {
            JsonArray ja = reader.readArray();
            if (ja != null) {
                ja.forEach(v -> {
                    JsonObject jo = (JsonObject) v;
                    Patient patient = new Patient();

                    patient.setId(jo.getString("_id"));
                    patient.setFirstName(jo.getString("first_name"));
                    patient.setLastName(jo.getString("last_name"));
                    patient.setGender(jo.getString("gender"));
                    patient.setBloodType(jo.getString("blood_type"));
                    patient.setYearOfBirth(jo.getInt("year_of_birth"));
                    JsonArray jaPhone = jo.getJsonArray("telephones");
                    List<String> telephones = new ArrayList<>();
                    jaPhone.forEach(jv -> {
                        telephones.add(jv.toString());
                    });
                    patient.setTelephones(telephones);
                    Address add = new Address();
                    JsonObject joAdd = jo.getJsonObject("address");
                    add.setCity(joAdd.getString("city"));
                    add.setDistrict(joAdd.getString("district"));
                    add.setStreet(joAdd.getString("street"));
                    add.setWard(joAdd.getString("ward"));

                    patient.setAddress(add);
                    List<Test> tests = new ArrayList<>();

                    jo.getJsonArray("tests").forEach(v1 -> {
                        JsonObject joTest = (JsonObject) v1;
                        Test test = new Test();

                        Date date = new Date();
                        JsonObject joDate = joTest.getJsonObject("date");
                        date.setDay(joDate.getInt("day"));
                        date.setMonth(joDate.getInt("month"));
                        date.setYear(joDate.getInt("year"));

                        test.setResult(joTest.getString("result"));
                        test.setCost(joTest.getJsonNumber("cost").doubleValue());
                        test.setTestId(joTest.getInt("test_id"));
                        test.setTestType(joTest.getString("test_type"));


                        test.setDate(date);
//
                        tests.add(test);
                    });

                    patient.setTests(tests);

                    p.add(patient);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return p;
    }


    public static void toFile(List<Patient> patients, String fileName) {
        try (
                JsonWriter writer = Json.createWriter(new FileWriter(fileName));
        ) {
            JsonArrayBuilder jaB = Json.createArrayBuilder();
            JsonObjectBuilder joB = Json.createObjectBuilder();

            for (Patient p : patients) {
                Address address = p.getAddress();
                JsonObject joAddress = joB
                        .add("city", address.getCity())
                        .add("district", address.getDistrict())
                        .add("street", address.getStreet())
                        .add("ward", address.getWard())
                        .build();

                JsonArrayBuilder jaPhone = Json.createArrayBuilder();
                for (String phone : p.getTelephones()) {
                    jaPhone.add(phone);
                }

                JsonArrayBuilder jaTest = Json.createArrayBuilder();
                for (Test test : p.getTests()) {
                    Date date = test.getDate();
                    JsonObject joDate = joB
                            .add("day", date.getDay())
                            .add("month", date.getMonth())
                            .add("year", date.getYear())
                            .build();
                    JsonObject joTest = joB
                            .add("date", joDate)
                            .add("result", test.getResult())
                            .add("cost", test.getCost())
                            .add("test_id", test.getTestId())
                            .add("test_type", test.getTestType())
                            .build();
                    jaTest.add(joTest);
                }

                JsonObject jo = joB
                        .add("_id", p.getId())
                        .add("first_name", p.getFirstName())
                        .add("last_name", p.getLastName())
                        .add("blood_type", p.getBloodType())
                        .add("gender", p.getGender())
                        .add("address", joAddress)
                        .add("tests", jaTest)
                        .add("telephones", jaPhone)
                        .add("year_of_birth", p.getYearOfBirth()).build();

                jaB.add(jo);
            }

            JsonArray ja = jaB.build();
            writer.write(ja);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
