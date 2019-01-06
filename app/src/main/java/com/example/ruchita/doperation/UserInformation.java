package com.example.ruchita.doperation;

import java.io.Serializable;

public class UserInformation implements Serializable {

    private  String receiver_name;
    private String receiver_phone;



    private String note_no;



    private String receiver_city;

    private  String sender_name;
    private String sender_phone;



    private String sender_branch;
    int amount;
    int commision_amount;
    int token_no;
    int sender_code;



    public UserInformation(String receiver_name,String receiver_phone,int commision_amount,int amount,String receiver_city,String note_no,String sender_branch,String sender_name,String sender_phone)
    {
    //String sender_name,String sender_phone,int sender_code,int token_no

       this.sender_name=sender_name;
        this.sender_phone=sender_phone;
    //this.token_no=token_no;
        this.sender_phone=sender_phone;
        this.receiver_name=receiver_name;
        this.receiver_phone=receiver_phone;
        this.amount=amount;
        this.commision_amount=commision_amount;

        this.note_no=note_no;
        this.receiver_city=receiver_city;
        this.sender_branch=sender_branch;
    }
    public int getAmount() {
        return amount;
    }
    public int getSender_code() {
        return sender_code;
    }
    public int getcommision_amount() {
        return commision_amount;
    }
    public int getToken_no() {
        return token_no;
    }
    public String getReceiver_phone() {
        return receiver_phone;
    }

    public String getSender_phone() {
        return sender_phone;
    }
    public String getSender_name() {
        return sender_name;
    }
    public String getReceiver_name() {
        return receiver_name;
    }


    public String getNote_no() {
        return note_no;
    }

    public String getReceiver_city() {
        return receiver_city;
    }

    public String getSender_branch() {
        return sender_branch;
    }


    //-----------------------------------------------------------------------------------
    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }
    public void setSender_name(String sender_name) {
        this.sender_name = sender_name;
    }

    public void setSender_phone(String sender_phone) {
        this.sender_phone = sender_phone;
    }
    public void setReceiver_phone(String receiver_phone) {
        this.receiver_phone = receiver_phone;
    }
    public void setToken_no(int token_no) {
        this.token_no = token_no;
    }
    public void setcommision_amount(int commision_amount) {
        this.commision_amount=commision_amount;
    }
    public void setSender_code(int sender_code) {
        this.sender_code = sender_code;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setNote_no(String note_no) {
        this.note_no = note_no;
    }


    public void setReceiver_city(String receiver_city) {

        this.receiver_city = receiver_city;
    }

    public void setSender_branch(String sender_branch) {
        this.sender_branch = sender_branch;
    }

}
