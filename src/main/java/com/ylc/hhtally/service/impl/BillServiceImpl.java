package com.ylc.hhtally.service.impl;

import com.ylc.hhtally.mapper.BillMapper;
import com.ylc.hhtally.pojo.Bill;
import com.ylc.hhtally.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper billMapper;

    @Override
    public boolean add(Bill bill) {
        int i = billMapper.add(bill);
        return i == 1;
    }

    @Override
    public boolean remove(int billId) {
        int i = billMapper.remove(billId);
        return i==1;
    }

    @Override
    public List<Bill> getAll() {
        return billMapper.getAll();
    }

    @Override
    public List<Bill> getByDate(String time) {
        return billMapper.getByDate(time);
    }

    @Override
    public List<Bill> getByLabel(int labelId) {
        return billMapper.getByLabel(labelId);
    }
}
