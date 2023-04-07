package com.ylc.hhtally.service;

import com.ylc.hhtally.pojo.Bill;

import java.util.List;

public interface BillService {
    boolean add(Bill bill);
    boolean remove(int billId);
    List<Bill> getAll();
    List<Bill> getByDate(String time);
    List<Bill> getByLabel(int labelId);
}
