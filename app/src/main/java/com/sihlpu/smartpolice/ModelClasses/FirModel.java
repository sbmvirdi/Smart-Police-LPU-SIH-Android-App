package com.sihlpu.smartpolice.ModelClasses;

public class FirModel {
    private String address,complaint,dob,email,gender,id,mobileno,name,policestation;

    public FirModel(String address, String complaint, String dob, String email, String gender, String id, String mobileno, String name, String policestation) {
        this.address = address;
        this.complaint = complaint;
        this.dob = dob;
        this.email = email;
        this.gender = gender;
        this.id = id;
        this.mobileno = mobileno;
        this.name = name;
        this.policestation = policestation;
    }

    public FirModel() {
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMobileno() {
        return mobileno;
    }

    public void setMobileno(String mobileno) {
        this.mobileno = mobileno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPolicestation() {
        return policestation;
    }

    public void setPolicestation(String policestation) {
        this.policestation = policestation;
    }
}
