package com.ylc.hhtally;

import com.ylc.hhtally.mapper.BillMapper;
import com.ylc.hhtally.pojo.Bill;
import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class MainTest {
    public static void main(String[] args) throws ParseException {
        String startTime;
        String endTime;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 20; i++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - i);
            int nowYear=calendar.get(Calendar.YEAR);
            int nowMon=calendar.get(Calendar.MONTH)+1;
            int nowDay=calendar.get(Calendar.DATE);
            System.out.println(nowYear+"-"+nowMon+"-"+nowDay);
        }
    }
}