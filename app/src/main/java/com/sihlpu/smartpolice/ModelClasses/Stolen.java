package com.sihlpu.smartpolice.ModelClasses;

public class Stolen {
    private String article,description,station,status;

    public Stolen() {
    }

    public Stolen(String article, String description, String station, String status) {
        this.article = article;
        this.description = description;
        this.station = station;
        this.status = status;
    }


    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
