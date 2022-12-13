package com.ylc.hhtally.mapper;

import com.ylc.hhtally.pojo.Label;

import java.util.List;

public interface BillMapper {
    List<Label> getAll();
    int add(Label label);
    int remove(int labelId);
}
