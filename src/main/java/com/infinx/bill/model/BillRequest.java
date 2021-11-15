package com.infinx.bill.model;

import lombok.Data;
@Data
public class BillRequest {
    private Long id;
    private String billTo;
    private double price;
    private String date;
    private double tax;
    private double total;
}
