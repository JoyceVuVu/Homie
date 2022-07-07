package com.example.homie_.model;

public class User {
    String username;
    String email;
    String pass;
    String address;
    String gender;
    String ava;

    public User(){}

    public User( String username, String email, String pass, String address, String gender, String ava) {
        this.username = username;
        this.email = email;
        this.pass = pass;
        this.address = address;
        this.gender = gender;
        this.ava = ava;
    }

    public User(String username,String email) {
        this.username = username;
        this.email = email;
    }

    public String getName() {
        return username;
    }

    public void setName(String name) {
        this.username = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAva() {
        return ava;
    }

    public void setAva(String ava) {
        this.ava = ava;
    }
}
