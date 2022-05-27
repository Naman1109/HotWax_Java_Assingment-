package DTO;

import java.io.Serializable;

public class userdto implements Serializable {

    private String fname, lname, email, address, city, state, country, zip, phone, password;

    public userdto(String fname, String lname, String email, String address, String city, String state, String country, String zip, String phone, String password) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.address = address;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zip = zip;
        this.phone = phone;
        this.password = password;
    }

    public userdto() {
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
