package com.ylc.hhtally.controller;

import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.pojo.Bill;
import com.ylc.hhtally.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Controller
@RequestMapping("/bill")
public class BillController {

    @Autowired
    BillService billService;

    @ResponseBody
    @PutMapping("/add")
    public ResultJson add(@RequestBody Bill bill){
//        System.out.println(bill);
        if (null==bill.getTime() || bill.getTime().isEmpty()){
            SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            String time = format.format(new Date(System.currentTimeMillis()));

            bill.setTime(time);
        }
        return billService.add(bill);
    }

    @ResponseBody
    @DeleteMapping("/remove")
    public ResultJson remove(int billId){
        return billService.remove(billId);
    }

    @ResponseBody
    @GetMapping("/getByDate")
    public ResultJson getByDate(String date) throws ParseException {

        return billService.getByDate(date);
    }

    @ResponseBody
    @GetMapping("/getByLabel")
    public ResultJson getByLabel(int labelId){
        return billService.getByLabel(labelId);
    }

    @ResponseBody
    @GetMapping("/getAll")
    public ResultJson getAll(){
        return billService.getAll();
    }
}
