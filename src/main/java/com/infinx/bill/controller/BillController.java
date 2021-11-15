package com.infinx.bill.controller;

import com.infinx.bill.model.Bill;
import com.infinx.bill.model.BillError;
import com.infinx.bill.model.BillRequest;
import com.infinx.bill.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@RestController
public class BillController {
    @Autowired
    BillService billService;

    @PostMapping("/addBill")
    public ResponseEntity<BillRequest> addBill(@RequestBody BillRequest bill) throws ParseException {
        return new ResponseEntity<BillRequest>(this.billService.addBill(bill), HttpStatus.CREATED);
    }

    @GetMapping("/bills")
    public ResponseEntity<List<Bill>> getAllBills() {
        return new ResponseEntity<List<Bill>>(this.billService.getAllBills(), HttpStatus.OK);    }

    @GetMapping("/bills/{id}")
    public ResponseEntity<Bill> findBillById(@PathVariable("id") Long id) {
        return new ResponseEntity<Bill>(this.billService.getBillById(id), HttpStatus.OK);
    }

    @GetMapping("/bills/due/{date}")
    public ResponseEntity<List<Bill>> findBillsByDueDate(@PathVariable("date") String date) {
        return new ResponseEntity<>(this.billService.findBillsByDueDate(date), HttpStatus.OK);
    }

    @ExceptionHandler({NullPointerException.class})
    public ResponseEntity<BillError> handleNullPointerException(NullPointerException nullPointerException) {
        BillError error = new BillError("404", nullPointerException.getMessage(), "Resource not found!");
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<BillError> handleException(Exception exception) {
        BillError error = new BillError("400", exception.getMessage(), "Something went wrong");
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }

}
