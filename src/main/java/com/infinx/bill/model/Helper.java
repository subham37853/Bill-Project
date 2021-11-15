package com.infinx.bill.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public static Bill billRequestToResponse(BillRequest billRequest) throws ParseException {
        Bill bill = new Bill();
        bill.setBillTo(billRequest.getBillTo());
        bill.setPrice(billRequest.getPrice());
        bill.setTax(billRequest.getTax());
        bill.setTotalAmount(billRequest.getTax() + billRequest.getPrice());
        bill.setDate(dateFormat.parse(billRequest.getDate()));
        return bill;
    }

    public static BillRequest fromBillToBillRequest(Bill bill) {
        BillRequest b = new BillRequest();
        b.setBillTo(bill.getBillTo());
        b.setDate(bill.getDate().toString());
        b.setPrice(bill.getPrice());
        b.setTax(bill.getTax());
        b.setTotal(bill.getTotalAmount());
        b.setId(bill.getId());
        return b;
    }
}
