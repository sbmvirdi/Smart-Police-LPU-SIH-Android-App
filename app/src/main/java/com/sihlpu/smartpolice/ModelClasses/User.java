package com.sihlpu.smartpolice.ModelClasses;

import java.io.Serializable;

public class User implements Serializable {

    private String email,uid,aadhaarno,mobileno,name,gender,a_uid;


    public User(String email, String uid, String name, String mobileno, String aadhaarno, String gender,String a_uid) {
        this.email = email;
        this.uid = uid;
        this.name = name;
        this.mobileno = mobileno;
        this.aadhaarno = aadhaarno;
        this.gender = gender;
        this.a_uid = a_uid;
    }

    public String getA_uid() {
        return a_uid;
    }

    public void setA_uid(String a_uid) {
        this.a_uid = a_uid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAadhaarno() {
        return aadhaarno;
    }

    public void setAadhaarno(String aadhaarno) {
        this.aadhaarno = aadhaarno;
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


    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }
}
