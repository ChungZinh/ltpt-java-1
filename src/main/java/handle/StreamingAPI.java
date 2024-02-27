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
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.stream.JsonGenerator;
import jakarta.json.stream.JsonParser;

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
public class StreamingAPI {
//    public static Patient readFromFile(String fileName) {
////        List<Patient> patients = new ArrayList<>();
//        Patient patient = new Patient();
//        String keyName = "";
//        List<Test> tests = new ArrayList<>();
//        List<String> telephones = new ArrayList<>();
//        Address add = null;
//        try (
//                JsonParser parser = Json.createParser(new FileReader(fileName));
//        ) {
//            while (parser.hasNext()) {
//                JsonParser.Event event = parser.next();
//
//                switch (event) {
//                    case START_OBJECT -> {
//                        if (keyName.equals("address")) {
//                            add = new Address();
//                        }
////                        else if (keyName.equals("Tests"))
////                            tests = new ArrayList<>();
////                        else if (keyName.equals("telephones"))
////                            telephones = new ArrayList<>();
//                        else
//                            patient = new Patient();
//                    }
//                    case START_ARRAY -> {
////                        tests = new ArrayList<>();
//                        if(keyName.equals("tests")){
//                            JsonArray jaTest = parser.getArray();
//                            jaTest.forEach(jv -> {
//                                Test test = new Test();
//                                JsonObject joTest = (JsonObject) jv;
//                                test.setResult(joTest.getString("result"));
//                                test.setTestId(joTest.getInt("testId"));
//                                test.setTestType(joTest.getString("testType"));
//                                test.setCost(joTest.getJsonNumber("cost").doubleValue());
//
//                                entity.Date date = new entity.Date();
//                                JsonObject joDate = joTest.getJsonObject("date");
//                                date.setDay(joDate.getInt("day"));
//                                date.setMonth(joDate.getInt("month"));
//                                date.setYear(joDate.getInt("year"));
//                                test.setDate(date);
//
//                                tests.add(test);;
//                            });
//                        }else{
//                            JsonArray jaPhone = parser.getArray();
//                            jaPhone.forEach(jv -> telephones.add(jv.toString()));
//                        }
//                    }
//                    case KEY_NAME -> keyName = parser.getString();
//                    case VALUE_STRING -> {
//                        if (keyName.equals("_id"))
//                            patient.setId(parser.getString());
//                        else if (keyName.equals("first_name"))
//                            patient.setFirstName(parser.getString());
//                        else if (keyName.equals("last_name"))
//                            patient.setLastName(parser.getString());
//                        else if (keyName.equals("blood_type"))
//                            patient.setBloodType(parser.getString());
//                        else if (keyName.equals("gender"))
//                            patient.setGender(parser.getString());
//                        else if (keyName.equals("city"))
//                            add.setCity(parser.getString());
//                        else if (keyName.equals("street"))
//                            add.setStreet(parser.getString());
//                        else if (keyName.equals("district"))
//                            add.setDistrict(parser.getString());
//                        else if (keyName.equals("ward"))
//                            add.setWard(parser.getString());
//                    }
//                    case VALUE_NUMBER -> {
//                        if (keyName.equals("year_of_birth"))
//                            patient.setYearOfBirth(parser.getInt());
//                    }
//                    case END_OBJECT -> {
//                            patient.setAddress(add);
//                    }
//                    case END_ARRAY -> {
//                        if(keyName.equals("tests"))
//                            patient.setTests(tests);
//                        else
//                            patient.setTelephones(telephones);
//                    }
//                    default -> {
//                    }
//
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return patient;
//    }

    public static List<Patient> readFromFiles(String fileName) {
        List<Patient> patients = new ArrayList<>();
        Patient patient = null;
        String keyName = "";
        List<Test> tests = new ArrayList<>();
        List<String> telephones = new ArrayList<>();
        Date date = null;
        Test test = null;
        Address add = null;
        try (
                JsonParser parser = Json.createParser(new FileReader(fileName));
        ) {
            while (parser.hasNext()) {
                JsonParser.Event event = parser.next();

                switch (event) {
                    case START_OBJECT -> {
                        if (keyName.equals("address")) {
                            add = new Address();
                        } else if (keyName.equals("date")) {
                            date = new Date();
                        } else if (keyName.equals("test")) {
                            test = new Test();
                        } else {
                            patient = new Patient();
                            tests = new ArrayList<>();
                            telephones = new ArrayList<>();
                        }
                    }
                    case START_ARRAY -> {
                        if (keyName.equals("tests")) {
                            tests = new ArrayList<>();
                        } else if (keyName.equals("telephones")) {
                            telephones = new ArrayList<>();
                        }
                    }
                    case KEY_NAME -> keyName = parser.getString();
                    case VALUE_STRING -> {
                        if (keyName.equals("_id"))
                            patient.setId(parser.getString());
                        else if (keyName.equals("first_name"))
                            patient.setFirstName(parser.getString());
                        else if (keyName.equals("last_name"))
                            patient.setLastName(parser.getString());
                        else if (keyName.equals("blood_type"))
                            patient.setBloodType(parser.getString());
                        else if (keyName.equals("gender"))
                            patient.setGender(parser.getString());
                        else if (keyName.equals("city"))
                            add.setCity(parser.getString());
                        else if (keyName.equals("street"))
                            add.setStreet(parser.getString());
                        else if (keyName.equals("district"))
                            add.setDistrict(parser.getString());
                        else if (keyName.equals("ward"))
                            add.setWard(parser.getString());
                        else if (keyName.equals("telephones"))
                            telephones.add(parser.getString());
                        else if (keyName.equals("result"))
                            test.setResult(parser.getString());
                        else if (keyName.equals("testType"))
                            test.setTestType(parser.getString());
                        else if (keyName.equals("day"))
                            date.setDay(parser.getInt());
                        else if (keyName.equals("month"))
                            date.setMonth(parser.getInt());
                        else if (keyName.equals("year"))
                            date.setYear(parser.getInt());
                    }
                    case VALUE_NUMBER -> {
                        if (keyName.equals("year_of_birth"))
                            patient.setYearOfBirth(parser.getInt());
                        else if (keyName.equals("testId"))
                            test.setTestId(parser.getInt());
                        else if (keyName.equals("cost"))
                            test.setCost(parser.getBigDecimal().doubleValue());
                        else if (keyName.equals("day"))
                            date.setDay(parser.getInt());
                        else if (keyName.equals("month"))
                            date.setMonth(parser.getInt());
                        else if (keyName.equals("year"))
                            date.setYear(parser.getInt());
                    }
                    case END_OBJECT -> {
                        if (keyName.equals("address")) {
                            patient.setAddress(add);
                        } else if (keyName.equals("date")) {
                            test.setDate(date);
                        } else if (keyName.equals("tests")) {
                            tests.add(test);
                        } else {
                            patient.setTests(tests);
                            patient.setTelephones(telephones);
                            patients.add(patient);
                        }
                    }
                    default -> {
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return patients;
    }

    public static void toFile(List<Patient> patients, String fileName) {
        try (
                JsonGenerator generator = Json.createGenerator(new FileWriter(fileName));
        ) {
            generator.writeStartArray();
            for (Patient p : patients) {
                generator.writeStartObject();
                generator.write("_id", p.getId())
                        .write("first_name", p.getFirstName())
                        .write("last_name", p.getLastName())
                        .write("year_of_birth", p.getYearOfBirth())
                        .write("blood_type", p.getBloodType());

                Address address = p.getAddress();
                if (address != null) {
                    generator.writeStartObject("address")
                            .write("city", address.getCity())
                            .write("street", address.getStreet())
                            .write("district", address.getDistrict())
                            .write("ward", address.getWard())
                            .writeEnd();
                }

                List<String> telephones = p.getTelephones();

                if (telephones != null) {
                    generator.writeStartArray("telephones");
                    for (String telephone : telephones) {
                        generator.write(telephone);
                    }
                    generator.writeEnd();
                }


                List<Test> tests = p.getTests();
                if (tests != null) {
                    generator.writeStartArray("tests");
                    for (Test test : tests) {
                        generator.writeStartObject()
                                .write("result", test.getResult())
                                .write("testId", test.getTestId())
                                .write("testType", test.getTestType())
                                .write("cost", test.getCost());
                        Date date = test.getDate();
                        if (date != null) {
                            generator.writeStartObject("date")
                                    .write("day", date.getDay())
                                    .write("month", date.getMonth())
                                    .write("year", date.getYear())
                                    .writeEnd();
                        }
                        generator.writeEnd();
                    }
                    generator.writeEnd();
                }

                generator.writeEnd();
            }

            generator.writeEnd();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
