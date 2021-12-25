package com.example.drugeasy;

public class Medicine {
    public  String name;
    public  String genericName;
    public  String indication;
    public  String does;
    public String price;
    public String sideEffect;

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getMg() {
        return mg;
    }

    public void setMg(String mg) {
        this.mg = mg;
    }

    String Brand;
    String mg;

    public Medicine(){


    }
    /*(String name, String genericName,String indication,String dose,String sideEffect,double price){
        this.name=name;
        this.indication=indication;
        this.genericName=genericName;
        this.price=price;
        this.does=dose;
        this.sideEffect=sideEffect;
    }**/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getDoes(){
        return does;
    }
public  void setDose(String dose){
        this.does=dose;
}
    public String getGenericName() {
        return genericName;
    }
public String getSideEffect(){
        return  sideEffect;
}
public void setSideEffect(String sideEffect){this.sideEffect=sideEffect;}

    public void setGenericName(String genericName) {
        this.genericName=genericName;
    }

    public String getIndication() {
        return indication;
    }

    public void setIndication(String indication) {
        this.indication =
        indication;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

