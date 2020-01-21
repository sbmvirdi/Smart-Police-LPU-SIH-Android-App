package com.sihlpu.smartpolice.ModelClasses;

public class punjab {
    private long total;
    private String district;


    public punjab(long total, String district) {
        this.total = total;
        this.district = district;
    }

    public punjab() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }
}
