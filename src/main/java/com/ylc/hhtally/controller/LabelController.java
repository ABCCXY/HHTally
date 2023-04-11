package com.ylc.hhtally.controller;

import com.ylc.hhtally.common.ResultJson;
import com.ylc.hhtally.pojo.Label;
import com.ylc.hhtally.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/label")
public class LabelController {

    @Autowired
    LabelService labelService;

    @ResponseBody
    @PostMapping("/add")
    public ResultJson add(String labelName){
        Label label = new Label();
        label.setLabelName(labelName);

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
