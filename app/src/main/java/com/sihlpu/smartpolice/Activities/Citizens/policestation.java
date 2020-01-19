package com.sihlpu.smartpolice.Activities.Citizens;

public class policestation {
    String state, district, mail, phone, inspector_name,nameofStation,no_of_constables, no_of_subinspecter;

    public policestation(String state, String district, String mail, String phone, String inspector_name, String nameofStation, String no_of_constables, String no_of_subinspecter) {
        this.state = state;
        this.district = district;
        this.mail = mail;
        this.phone = phone;
        this.inspector_name = inspector_name;
        this.nameofStation = nameofStation;
        this.no_of_constables = no_of_constables;
        this.no_of_subinspecter = no_of_subinspecter;
    }

    public policestation() {
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getInspector_name() {
        return inspector_name;
    }

    public void setInspector_name(String inspector_name) {
        this.inspector_name = inspector_name;
    }

    public String getNameofStation() {
        return nameofStation;
    }

    public void setNameofStation(String nameofStation) {
        this.nameofStation = nameofStation;
    }

    public String getNo_of_constables() {
        return no_of_constables;
    }

    public void setNo_of_constables(String no_of_constables) {
        this.no_of_constables = no_of_constables;
    }

    public String getNo_of_subinspecter() {
        return no_of_subinspecter;
    }

    public void setNo_of_subinspecter(String no_of_subinspecter) {
        this.no_of_subinspecter = no_of_subinspecter;
    }
}
