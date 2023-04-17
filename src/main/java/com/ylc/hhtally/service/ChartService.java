package com.ylc.hhtally.service;

import com.ylc.hhtally.common.ResultJson;

public interface ChartService {
    ResultJson getYearIncome(String year);
    ResultJson getMonthIncome(String year,String month);
    ResultJson getWeekIncome();

    ResultJson getYearInfor(String year);
    ResultJson getMonthInfor(String year,String month);
    ResultJson getWeekInfor();
}
