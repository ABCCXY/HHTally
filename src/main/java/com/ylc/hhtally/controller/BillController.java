package com.ylc.hhtally.controller;

import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.pojo.Bill;
import com.ylc.hhtally.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/bill")
public class BillController {
    @Autowired
    BillService billService;

    @ResponseBody
    @PostMapping("/add")
    public ResultJson add(Bill bill){
        if (null==bill.getTime()){
            bill.setTime(LocalDate.now().toString());
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
    public ResultJson getByDate(String date){

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
