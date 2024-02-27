/*
 * @ (#) $NAME.java         2/26/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package entity;

import java.util.List;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 2/26/2024
 */
public class Patient {
    private String id;
    private String firstName;
    private String lastName;
    private String gender;
    private String bloodType;
    private int yearOfBirth;

    private Address address;

    private List<String> telephones;

    private List<Test> tests;

    public Patient() {
    }

    public Patient(String id, String firstName, String lastName, String gender, String bloodType, int yearOfBirth, Address address, List<String> telephones, List<Test> tests) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.bloodType = bloodType;
        this.yearOfBirth = yearOfBirth;
        this.address = address;
        this.telephones = telephones;
        this.tests = tests;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<String> getTelephones() {
        return telephones;
    }

    public void setTelephones(List<String> telephones) {
        this.telephones = telephones;
    }

    public List<Test> getTests() {
        return tests;
    }

    public void setTests(List<Test> tests) {
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", address=" + address +
                ", telephones=" + telephones +
                ", tests=" + tests +
                '}';
    }
}
