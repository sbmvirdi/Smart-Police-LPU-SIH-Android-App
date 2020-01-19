package com.sihlpu.smartpolice.ModelClasses;

public class NocModel {
    private String address,id,typeofnoc,mobile,name,status;

    public String getStatus() {
        return status;
    }

    public NocModel() {
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NocModel(String address, String id, String typeofnoc, String mobile, String name, String status) {
        this.address = address;
        this.id = id;
        this.typeofnoc = typeofnoc;
        this.mobile = mobile;
        this.name = name;
        this.status =status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeofnoc() {
        return typeofnoc;
    }

    public void setTypeofnoc(String typeofnoc) {
        this.typeofnoc = typeofnoc;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
