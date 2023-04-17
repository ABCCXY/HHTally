package com.ylc.hhtally.service;

import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.pojo.Bill;

import java.text.ParseException;
import java.util.List;

public interface BillService {
    ResultJson add(Bill bill);
    ResultJson remove(int billId);
    ResultJson getAll();
    ResultJson getByDate(String date) throws ParseException;
    ResultJson getByLabel(int labelId);
}
