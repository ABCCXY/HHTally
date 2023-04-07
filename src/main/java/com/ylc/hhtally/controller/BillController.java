package com.ylc.hhtally.controller;

import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.pojo.Bill;
import com.ylc.hhtally.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
        boolean ret = billService.add(bill);
        if (!ret)return ResultJson.failed(-1,"账单添加失败");
        else return ResultJson.success("账单添加成功");
    }

    @DeleteMapping("/remove")
    public ResultJson remove(int billId){
        boolean ret = billService.remove(billId);
        return ;
    }

    @GetMapping("/getByDate")
    public List<Bill> getByDate(String date){

        return billService.getByDate(date);
    }

    @GetMapping("/getByLabel")
    public List<Bill> getByLabel(int labelId){
        return billService.getByLabel(labelId);
    }

    @GetMapping("/getAll")
    public List<Bill> getAll(){
        return billService.getAll();
    }
}
