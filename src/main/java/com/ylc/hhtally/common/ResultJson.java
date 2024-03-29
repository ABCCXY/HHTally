package com.ylc.hhtally.common;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultJson implements Serializable {

    private static final long SerialVersionUID = 1L;
    private Integer code;
    private String msg;
    private Object data;

    public static ResultJson success(ResultCode resultCode, Object data) {
        return new ResultJson(resultCode.code(), resultCode.message(), data);
    }

    public static ResultJson success(Integer code, String msg, Object data){
        return new ResultJson(code,msg,data);
    }

    public static ResultJson success(Integer code, String msg){
        return new ResultJson(code,msg,null);
    }

    public static ResultJson failed(ResultCode resultCode) {
        return new ResultJson(resultCode.code(), resultCode.message(), null);
    }
    public static ResultJson failed(Integer code, String msg){
        return new ResultJson(code,msg,null);
    }

    @Override
    public String toString() {
        ObjectMapper objectMapper = new ObjectMapper();
        String result;
        try {
            result = objectMapper.writeValueAsString(this);
        } catch (Exception e) {
            result = "{}";
        }
        return result;
    }
}
