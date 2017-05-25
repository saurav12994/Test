package com.example.sourabh.bookmyticket;

/**
 * Created by Sourabh on 13-01-2017.
 */
public class Userinformation {
    public String nam;
    public String address;
    public String phone;
    public String email;
    public Userinformation(){

    }

    public Userinformation(String address, String phone, String email, String nam) {
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.nam = nam;
    }
    public String getNam() {
        return nam;
    }


    public String getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getEmail() {
        return email;
    }


}

