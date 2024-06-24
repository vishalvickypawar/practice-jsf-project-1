package org.example;

public class MobilePhone {
    private int id;
    private String name;
    private String os;
    private int ram;
    private int storage;
    private float price;

    public MobilePhone(int id, String name, String os, int ram, int storage, float price) {
        this.id = id;
        this.name = name;
        this.os = os;
        this.ram = ram;
        this.storage = storage;
        this.price = price;
    }

    public MobilePhone() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
