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
    BillMapper billMapper;

    @Override
    public String add(Bill bill) {
        String msg=null;
        int i = billMapper.add(bill);
        if (i==1)msg="账单添加成功";
        else msg="账单添加失败";
        return msg;
    }

    @Override
    public String remove(int billId) {
        String msg=null;
        int i = billMapper.remove(billId);
        if (i==1)msg="账单删除成功";
        else msg="账单删除失败";
        return msg;
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
