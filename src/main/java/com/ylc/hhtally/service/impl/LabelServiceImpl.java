package com.ylc.hhtally.service.impl;

import com.ylc.hhtally.common.ResultCode;
import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.mapper.LabelMapper;
import com.ylc.hhtally.pojo.Label;
import com.ylc.hhtally.service.LabelService;
import com.ylc.hhtally.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LabelServiceImpl implements LabelService {
    @Autowired
    private LabelMapper labelMapper;

    @Override
    public ResultJson add(Label label) {
        if (labelMapper.addReturn(label.getLabelName())!=0)
            return ResultJson.failed(ResultCode.ERROR.code(),"添加失败");
        int i = labelMapper.add(label);
        if (i==1)return ResultJson.success(ResultCode.SUCCESS.code(), "添加成功",labelMapper.addReturn(label.getLabelName()));
        else return ResultJson.failed(ResultCode.ERROR.code(),"添加失败");
    }

    @Override
    public ResultJson remove(int labelId) {
        int i = labelMapper.remove(labelId,Integer.parseInt(JwtUtil.userId));
        if (i==1)return ResultJson.success(ResultCode.SUCCESS.code(), "删除成功");
        else return ResultJson.failed(ResultCode.ERROR.code(),"删除失败");
    }

    @Override
    public ResultJson getAll() {
        return ResultJson.success(ResultCode.SUCCESS.code(), "获取成功", labelMapper.getAll(Integer.parseInt(JwtUtil.userId)));
    }
}
