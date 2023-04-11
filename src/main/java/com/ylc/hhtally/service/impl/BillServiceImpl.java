package com.ylc.hhtally.service.impl;

import com.ylc.hhtally.common.ResultCode;
import com.ylc.hhtally.common.ResultJson;
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
    public ResultJson add(Bill bill) {
        int i = billMapper.add(bill);
        return i == 1?ResultJson.success(ResultCode.SUCCESS,null):ResultJson.failed(ResultCode.ERROR);
    }

    @Override
    public ResultJson remove(int billId) {
        int i = billMapper.remove(billId);
        return i==1?ResultJson.success(ResultCode.SUCCESS,null):ResultJson.failed(ResultCode.ERROR);
    }

    @Override
    public ResultJson getAll() {
        return ResultJson.success(ResultCode.SUCCESS, billMapper.getAll());
    }

    @Override
    public ResultJson getByDate(String time) {
        return ResultJson.success(ResultCode.SUCCESS, billMapper.getByDate(time));
    }

    @Override
    public ResultJson getByLabel(int labelId) {
        return ResultJson.success(ResultCode.SUCCESS, billMapper.getByLabel(labelId));
    }
}
