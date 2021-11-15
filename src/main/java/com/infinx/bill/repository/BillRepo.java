package com.infinx.bill.repository;

import com.infinx.bill.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface BillRepo extends JpaRepository<Bill, Long> {

    String query = "Select * from Bill where date like ':queryDate%'";

    public List<Bill> findAll();

    public Optional<Bill> findById(Long id);

//    @Query(value = "from Bill t where date LIKE CONCAT(:date, '%')")
    public List<Bill> findByDate(Date date);
}
