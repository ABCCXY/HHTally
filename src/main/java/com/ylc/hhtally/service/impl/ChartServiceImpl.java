package com.ylc.hhtally.service.impl;

import com.ylc.hhtally.common.ResultCode;
import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.mapper.ChartMapper;
import com.ylc.hhtally.service.ChartService;
import com.ylc.hhtally.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChartServiceImpl implements ChartService {
    @Autowired
    private ChartMapper chartMapper;

    @Override
    public ResultJson getYearIncome(String year) {
        double yearSum=0;
        Double[] month=null;
        double[] monthSum = new double[12];
        int cntMon=12;
        int year1=Integer.parseInt(year);
        Calendar calendar=Calendar.getInstance();
        int nowYear=calendar.get(Calendar.YEAR);
        int nowMon=calendar.get(Calendar.MONTH)+1;
        if (year1==nowYear){
            cntMon=nowMon;
        }else if (year1>nowYear){
            return ResultJson.failed(ResultCode.ERROR.code(),"查询失败");
        }

        for (int i = 0; i <cntMon ; i++) {
            month=chartMapper.getMonthSumIncome(String.valueOf(i+1), Integer.parseInt(JwtUtil.userId));
            monthSum[i]=getMonthSum(month);
            yearSum+=monthSum[i];
        }

        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("yearSum",yearSum);
        dataMap.put("monthSum",monthSum);
        dataMap.put("monthAverage",yearSum/cntMon);

        return new ResultJson(ResultCode.SUCCESS.code(), "查询成功！",dataMap);
    }

    @Override
    public ResultJson getYearInfor(String year) {
        double yearSum=0;
        Double[] month=null;
        double[] monthSum = new double[12];
        int cntMon=12;
        int year1=Integer.parseInt(year);
        Calendar calendar=Calendar.getInstance();
        int nowYear=calendar.get(Calendar.YEAR);
        int nowMon=calendar.get(Calendar.MONTH)+1;
        if (year1==nowYear){
            cntMon=nowMon;
        }else if (year1>nowYear){
            return ResultJson.failed(ResultCode.ERROR.code(),"查询失败");
        }

        for (int i = 0; i <cntMon ; i++) {
            month=chartMapper.getMonthSum(String.valueOf(i+1), Integer.parseInt(JwtUtil.userId));
            monthSum[i]=getMonthSum(month);
            yearSum+=monthSum[i];
        }

        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("yearSum",yearSum);
        dataMap.put("monthSum",monthSum);
        dataMap.put("monthAverage",yearSum/cntMon);

        return new ResultJson(ResultCode.SUCCESS.code(), "查询成功！",dataMap);
    }

    public double getMonthSum(Double[] month){
        double sum=0;
        for (int i = 0; i < month.length; i++) {
            sum+=month[i];
        }
        return sum;
    }

    @Override
    public ResultJson getMonthInfor(String year,String month) {
        double monthSum=0;
        int year1=Integer.parseInt(year);
        int month1=Integer.parseInt(month);
        int cntDay=cntDay(year1,month1);

        Calendar calendar=Calendar.getInstance();
        int nowYear=calendar.get(Calendar.YEAR);
        int nowMon=calendar.get(Calendar.MONTH)+1;
        int nowDay=calendar.get(Calendar.DATE);
        if (year1==nowYear&&month1==nowMon){
            cntDay=nowDay;
        }else if (year1>nowYear||year1<=nowYear&&month1>nowMon){
            return ResultJson.failed(ResultCode.ERROR.code(),"查询失败");
        }

        Double[] mon=chartMapper.getMonthSum(month, Integer.parseInt(JwtUtil.userId));
        monthSum=getMonthSum(mon);

        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("monthSum",monthSum);
        dataMap.put("dayAverage",monthSum/cntDay);
        return new ResultJson(ResultCode.SUCCESS.code(), "查询成功！",dataMap);
    }
    public int cntDay(int year,int month){
        int cnt=0;
        switch (month){
            case 1:cnt=31;break;
            case 2:cnt=isLeapYear(year)?29:28;break;
            case 3:cnt=31;break;
            case 4:cnt=30;break;
            case 5:cnt=31;break;
            case 6:cnt=30;break;
            case 7:cnt=31;break;
            case 8:cnt=31;break;
            case 9:cnt=30;break;
            case 10:cnt=31;break;
            case 11:cnt=30;break;
            case 12:cnt=31;break;
        }
        return cnt;
    }
    public boolean isLeapYear(int year){
        if (year%4==0&&year%100!=0 || year%400==0)return true;
        else return false;
    }

    @Override
    public ResultJson getWeekInfor() {
        double weekSum=0;
        double[] everyday = new double[7];
        Double[] day=null;
        String startTime;
        String endTime;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 7; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - i);
            startTime = sdf.format(calendar.getTime());
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
            endTime = sdf.format(calendar.getTime());

            day=chartMapper.getDaySum(startTime,endTime,Integer.parseInt(JwtUtil.userId));
            everyday[i]=getDaySum(day);
            weekSum+=everyday[i];
        }

        Map<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("weekSum",weekSum);
        dataMap.put("dayAverage",weekSum/7);
        dataMap.put("everyday",everyday);

        return new ResultJson(ResultCode.SUCCESS.code(), "查询成功！",dataMap);
    }
    public double getDaySum(Double[] day){
        double sum=0;
        for (int i = 0; i < day.length; i++) {
            sum+=day[i];
        }
        return sum;
    }
}
