package com.ylc.hhtally.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bill {
    private int billId;
    private int userId;
    private int labelId;
    private double money;
    private String time;
    private String remark;
    private String shopkeeper;
}
