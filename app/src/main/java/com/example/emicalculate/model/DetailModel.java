package com.example.emicalculate.model;

public class DetailModel {
    private String detail_balance;
    private String detail_emi;
    private String detail_gst;
    private String detail_interest;
    private String detail_months;
    private String detail_prePayment;
    private String detail_principal;
    private String detail_var_rate;
    private int id;
    public DetailModel() {

    }


    public DetailModel(String str, String str2, String str3, String str4) {
        this.detail_months = str;
        this.detail_principal = str2;
        this.detail_interest = str3;
        this.detail_balance = str4;
    }

    public String getDetail_balance() {
        return this.detail_balance;
    }

    public String getDetail_emi() {
        return this.detail_emi;
    }

    public String getDetail_gst() {
        return this.detail_gst;
    }

    public String getDetail_interest() {
        return this.detail_interest;
    }

    public String getDetail_months() {
        return this.detail_months;
    }

    public String getDetail_prePayment() {
        return this.detail_prePayment;
    }

    public String getDetail_principal() {
        return this.detail_principal;
    }

    public String getDetail_var_rate() {
        return this.detail_var_rate;
    }

    public int getId() {
        return this.id;
    }

    public void setDetail_balance(String str) {
        this.detail_balance = str;
    }

    public void setDetail_emi(String str) {
        this.detail_emi = str;
    }

    public void setDetail_gst(String str) {
        this.detail_gst = str;
    }

    public void setDetail_interest(String str) {
        this.detail_interest = str;
    }

    public void setDetail_months(String str) {
        this.detail_months = str;
    }

    public void setDetail_prePayment(String str) {
        this.detail_prePayment = str;
    }

    public void setDetail_principal(String str) {
        this.detail_principal = str;
    }

    public void setDetail_var_rate(String str) {
        this.detail_var_rate = str;
    }

    public void setId(int i) {
        this.id = i;
    }
}
