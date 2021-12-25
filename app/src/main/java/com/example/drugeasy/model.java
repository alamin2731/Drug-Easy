package com.example.drugeasy;

public class model {
    String mg;
    String name, genericName, brand, purl;

    public model(String mg, String name, String genericName, String brand, String purl) {
        this.mg = mg;
        this.name = name;
        this.genericName = genericName;
        this.brand = brand;
        this.purl = purl;
    }

    public model() {
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}