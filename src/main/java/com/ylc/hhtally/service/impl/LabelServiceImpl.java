package com.ylc.hhtally.service.impl;

import com.ylc.hhtally.common.ResultCode;
import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.mapper.LabelMapper;
import com.ylc.hhtally.pojo.Label;
import com.ylc.hhtally.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;

    @Override
    public ResultJson add(Label label) {
        int i = labelMapper.add(label);
        if (i==1)return ResultJson.success(ResultCode.SUCCESS, null);
        else return ResultJson.failed(ResultCode.ERROR);
    }

    @Override
    public ResultJson remove(int labelId) {
        int i = labelMapper.remove(labelId);
        if (i==1)return ResultJson.success(ResultCode.SUCCESS, null);
        else return ResultJson.failed(ResultCode.ERROR);
    }

    @Override
    public ResultJson getAll() {
        return ResultJson.success(ResultCode.SUCCESS, labelMapper.getAll());
    }
}
