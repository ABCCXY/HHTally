package com.ylc.hhtally.service.impl;

import com.ylc.hhtally.common.ResultCode;
import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.mapper.BillMapper;
import com.ylc.hhtally.pojo.Bill;
import com.ylc.hhtally.service.BillService;
import com.ylc.hhtally.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    private BillMapper billMapper;

    @Override
    public ResultJson add(Bill bill) {
        bill.setUserId(Integer.parseInt(JwtUtil.userId));
        int i = billMapper.add(bill);
        return i == 1?
                ResultJson.success(ResultCode.SUCCESS.code(),"添加成功")
                :ResultJson.failed(ResultCode.ERROR.code(),"添加失败");
    }

    @Override
    public ResultJson remove(int billId) {
        int i = billMapper.remove(billId,Integer.parseInt(JwtUtil.userId));
        return i==1?
                ResultJson.success(ResultCode.SUCCESS.code(),"删除成功")
                :ResultJson.failed(ResultCode.ERROR.code(),"删除失败");
    }

    @Override
    public ResultJson getAll() {
        return ResultJson.success(ResultCode.SUCCESS.code(), "获取成功",billMapper.getAll(Integer.parseInt(JwtUtil.userId)));
    }

    @Override
    public ResultJson getByDate(String time) throws ParseException {
        System.out.println("time:"+time);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = dateFormat.parse(time);
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE,1);

        String time2=dateFormat.format(calendar.getTime());
        System.out.println("time2:"+time2);

        return ResultJson.success(ResultCode.SUCCESS.code(),  "获取成功",billMapper.getByDate(time,time2, Integer.parseInt(JwtUtil.userId)));
    }

    @Override
    public ResultJson getByLabel(int labelId) {
        return ResultJson.success(ResultCode.SUCCESS.code(),  "获取成功",billMapper.getByLabel(labelId, Integer.parseInt(JwtUtil.userId)));
    }
}
