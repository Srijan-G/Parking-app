package com.example.finalapp2;

public class users {
    String id;
    String name;
    String phone;
    String start_time;
    String end_time;
    String date;
    boolean flag;

    public users(String id, String name, String phone, String start_time, String end_time,String date,boolean flag) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.start_time = start_time;
        this.end_time = end_time;
        this.flag=flag;
        this.date=date;
    }

    public String getId() {
        return id;
    }

    public users() {
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getStart_time() {
        return start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public String getDate() {
        return date;
    }

    public boolean isFlag() {
        return flag;
    }
}
