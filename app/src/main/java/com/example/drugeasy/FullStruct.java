package com.example.drugeasy;

public class FullStruct {
    String name,genericName,indication,brand,mg,price, sideEffect;

    public FullStruct(String name, String genericName, String indication, String brand, String mg, String price, String sideEffect) {
        this.name = name;
        this.genericName = genericName;
        this.indication = indication;
        this.brand = brand;
        this.mg = mg;
        this.price = price;
        this.sideEffect = sideEffect;
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

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSideEffect() {
        return sideEffect;
    }

    public void setSideEffect(String sideEffect) {
        this.sideEffect = sideEffect;
    }

    public FullStruct() {
    }
}
