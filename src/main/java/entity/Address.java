/*
 * @ (#) $NAME.java         2/26/2024
 *
 * Copyright (c) 2024 IUH.
 *
 */

package entity;

/*
 * @description: ...
 * @author: Vinh Trung Pham
 * @studentID: 20119821
 * @date: 2/26/2024
 */
public class Address {
    private String city;
    private String district;
    private String street;
    private String ward;

    public Address() {
    }

    public Address(String city, String district, String street, String ward) {
        this.city = city;
        this.district = district;
        this.street = street;
        this.ward = ward;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", street='" + street + '\'' +
                ", ward='" + ward + '\'' +
                '}';
    }
}
