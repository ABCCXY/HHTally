package com.ylc.hhtally.service.impl;

import com.ylc.hhtally.mapper.LabelMapper;
import com.ylc.hhtally.pojo.Label;
import com.ylc.hhtally.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    LabelMapper labelMapper;

    @Override
    public String add(Label label) {
        String msg=null;
        int i = labelMapper.add(label);
        if (i==1)msg="添加成功";
        else msg="添加失败";
        return msg;
    }

    @Override
    public String remove(int labelId) {
        String msg=null;
        int i = labelMapper.remove(labelId);
        if (i==1)msg="删除成功";
        else msg="删除失败";
        return msg;
    }

    @Override
    public List<Label> getAll() {
        List<Label> labelList = labelMapper.getAll();
        return labelList;
    }
}
