package com.infinx.bill.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Bill {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String billTo;
    private double price;
    private Date date;
    private double tax;
    private double totalAmount;
    public Bill() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillTo() {
        return billTo;
    }

    public void setBillTo(String billTo) {
        this.billTo = billTo;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public void setTotalAmount(double amount) {
        this.totalAmount = amount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }
}
