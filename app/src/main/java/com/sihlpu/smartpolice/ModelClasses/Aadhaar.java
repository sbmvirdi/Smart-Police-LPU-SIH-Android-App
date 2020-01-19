package com.sihlpu.smartpolice.ModelClasses;

public class Aadhaar {
    private String available,name,uid;
    private String phone,aadharnumber,gender;

    public Aadhaar(String available, String name, String uid, String phone, String aadharnumber, String gender) {
        this.available = available;
        this.name = name;
        this.uid = uid;
        this.phone = phone;
        this.aadharnumber = aadharnumber;
        this.gender = gender;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Aadhaar() {
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAadharnumber() {
        return aadharnumber;
    }

    public void setAadharnumber(String aadharnumber) {
        this.aadharnumber = aadharnumber;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
