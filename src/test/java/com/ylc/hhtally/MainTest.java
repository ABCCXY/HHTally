package com.ylc.hhtally;

import com.ylc.hhtally.pojo.Bill;
import com.ylc.hhtally.common.ResultJson;

import java.util.ArrayList;
import java.util.List;

public class MainTest {
    public static void main(String[] args) {
        Bill bill1 = new Bill(1, 1, 1, 20.5, "2022", "123", "sda");
        Bill bill2 = new Bill(1, 1, 1, 20.5, "2022", "123", "sda");
        Bill bill3 = new Bill(1, 1, 1, 20.5, "2022", "123", "sda");
        List<Bill> billList = new ArrayList<>();
        billList.add(bill1);
        billList.add(bill2);
        billList.add(bill3);
        System.out.println(ResultJson.success(billList));
        System.out.println(ResultJson.failed(401, "yonghum"));
    }
}