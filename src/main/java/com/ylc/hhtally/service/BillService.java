package com.ylc.hhtally.service;

import com.ylc.hhtally.pojo.Bill;

import java.util.List;

public interface BillService {
    String add(Bill bill);
    String remove(int billId);
    List<Bill> getAll();
    List<Bill> getByDate(String time);
    List<Bill> getByLabel(int labelId);
}
