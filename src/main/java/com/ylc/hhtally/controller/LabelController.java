package com.ylc.hhtally.controller;

import com.ylc.hhtally.mapper.LabelMapper;
import com.ylc.hhtally.pojo.Label;
import com.ylc.hhtally.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/label")
public class LabelController {
    @Autowired
    LabelService labelService;


    @PostMapping("/add")
    public String add(String labelName){
        Label label = new Label();
        label.setLabelName(labelName);

        return labelService.add(label);
    }
    @DeleteMapping("/remove")
    public String remove(int labelId){
        return labelService.remove(labelId);
    }

    @GetMapping("/getAll")
    public List<Label> getAll(){
        return labelService.getAll();
    }
}
