package com.ylc.hhtally.service;

import com.ylc.hhtally.pojo.Label;

import java.util.List;

public interface LabelService {
    String add(Label label);
    String remove(int labelId);
    List<Label> getAll();
}
