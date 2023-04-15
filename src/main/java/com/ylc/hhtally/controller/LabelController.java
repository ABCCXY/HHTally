package com.ylc.hhtally.controller;

import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.pojo.Label;
import com.ylc.hhtally.service.LabelService;
import com.ylc.hhtally.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@Controller
@RequestMapping("/label")
public class LabelController {

    @Autowired
    LabelService labelService;

    @ResponseBody
    @PutMapping("/add")
    public ResultJson add(String labelName){
        Label label = new Label();
        label.setLabelName(labelName);
        System.out.println("userId: " + JwtUtil.userId);
        label.setUserId(Integer.valueOf(JwtUtil.userId));
        return labelService.add(label);
    }

    @ResponseBody
    @DeleteMapping("/remove")
    public ResultJson remove(int labelId){
        return labelService.remove(labelId);
    }

    @ResponseBody
    @GetMapping("/getAll")
    public ResultJson getAll(){
        return labelService.getAll();
    }
}
