package com.ylc.hhtally.controller;

import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/chart")
public class ChartController {
    @Autowired
    private ChartService chartService;

    @GetMapping("/getYearIncome")
    public ResultJson getYearIncome(String year){
        return  chartService.getYearIncome(year);
    }

    @GetMapping("/getYearInfor")
    public ResultJson getYearInfor(String year){
        return chartService.getYearInfor(year);
    }

    @GetMapping("/getMonthInfor")
    public ResultJson getMonthInfor(String year,String month){
        return chartService.getMonthInfor(year,month);
    }

    @GetMapping("/getWeekInfor")
    public ResultJson getWeekInfor(){
        return chartService.getWeekInfor();
    }

}
