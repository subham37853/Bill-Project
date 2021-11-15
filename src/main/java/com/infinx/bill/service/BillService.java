package com.infinx.bill.service;

import com.infinx.bill.model.Bill;
import com.infinx.bill.model.BillRequest;
import com.infinx.bill.model.Helper;
import com.infinx.bill.repository.BillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BillService {
    @Autowired
    BillRepo billRepo;

    public List<Bill> getAllBills() {
        return this.billRepo.findAll();
    }

    public Bill getBillById(Long id) {
        return this.billRepo.findById(id)
                .orElseThrow(() -> new NullPointerException("No Bill was found with id = " + id));
    }

    @Transactional
    public BillRequest addBill(BillRequest bill) throws ParseException {
        Bill save = this.billRepo.save(Helper.billRequestToResponse(bill));
        return Helper.fromBillToBillRequest(save);
    }


    public List<Bill> findBillsByDueDate(String date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date d = null;
        try {
            d = dateFormat.parse(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return this.billRepo.findByDate(d);
    }
}
