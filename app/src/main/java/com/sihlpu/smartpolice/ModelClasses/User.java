package com.sihlpu.smartpolice.ModelClasses;

public class User {

    private String email,uid,name,mobileno;
    private long gender;

    public User(String email, String uid, String name, long gender, String mobileno) {
        this.email = email;
        this.uid = uid;
        this.name = name;
        this.gender = gender;
        this.mobileno = mobileno;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGender() {
        return gender;
    }

    public void setGender(long gender) {
        this.gender = gender;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
