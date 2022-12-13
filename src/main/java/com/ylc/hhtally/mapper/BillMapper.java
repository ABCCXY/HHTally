package com.ylc.hhtally.mapper;

import com.ylc.hhtally.pojo.Bill;
import com.ylc.hhtally.pojo.Label;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BillMapper {
    int add(Bill bill);
    int remove(int billId);
    List<Bill> getByDate(String time);
    List<Bill> getByLabel(int labelId);
    List<Bill> getAll();
}
