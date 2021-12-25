package com.example.drugeasy;

public class MainStructure {
    String name, genericName, indication, does, sideEffect;
    String brand;
    String url;

    public MainStructure() {
    }

    public MainStructure(String name, String genericName, String indication, String does, String sideEffect, String brand, String url) {
        this.name = name;
        this.genericName = genericName;
        this.indication = indication;
        this.does = does;
        this.sideEffect = sideEffect;
        this.brand = brand;
        this.url = url;
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

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication = indication;
    }

    public String getDoes() {
        return does;
    }

    public void setDoes(String does) {
        this.does = does;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
