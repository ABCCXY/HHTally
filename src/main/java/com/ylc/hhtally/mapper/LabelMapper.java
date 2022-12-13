package com.ylc.hhtally.mapper;

import com.ylc.hhtally.pojo.Label;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabelMapper {
    List<Label> getAll();
    int add(Label label);
    int remove(int labelId);
}
