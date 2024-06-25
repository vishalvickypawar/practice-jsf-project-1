package org.example;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named("MobilePhone")
@RequestScoped
public class MobilePhoneBean implements Serializable {
    private String repoName = "Mobile Phones Repository";
    private String name;
    private String os;
    private int ram;
    private int storage;
    private float price;

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<MobilePhone> getAllMobiles(){
        return MobileDatabaseConnection.getAllRecords();
    }

    public String addMobile(){
        int result = MobileDatabaseConnection.saveRecord(name,os, ram, storage, price);
        if(result!=0){
            return "view.xhtml?faces-redirect=true";
        } else {
            return "create.xhtml?faces-redirect=true";
        }
    }

    public void onValueChange(ValueChangeEvent valueChangeEvent){
        this.price = Float.parseFloat(valueChangeEvent.getNewValue().toString());
    }
}
