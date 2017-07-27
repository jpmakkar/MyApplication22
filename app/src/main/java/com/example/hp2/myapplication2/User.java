package com.example.hp2.myapplication2;

/**
 * Created by hp 2 on 13-07-2017.
 */

public class User {
    int icon;
    String name;
    String phone;

    public User(){

    }

    public User(int icon, String name, String phone) {
        this.icon = icon;
        this.name = name;
        this.phone = phone;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
