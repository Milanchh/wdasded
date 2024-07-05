package com.example.hrmanagementmilan;


public class admin {
    private int id;
    private String name;
    private String adress;
    private int num;

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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public admin(int id, String name, String adress, int num) {
        this.id = id;

        this.name = name;
        this.adress = adress;
        this.num = num;
    }
}