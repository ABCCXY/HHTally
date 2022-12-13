package com.ylc.hhtally.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Label {
    private int labelId;
    private int userId;
    private String labelName;
    private String icon;
}
