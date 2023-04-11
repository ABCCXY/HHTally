package com.ylc.hhtally.service;

import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.pojo.Label;

import java.util.List;

public interface LabelService {
    ResultJson add(Label label);
    ResultJson remove(int labelId);
    ResultJson getAll();
}
