package com.phieuthu_lts.comon.Enum;

import com.example.web_api_test.comon.Enum.ResponseEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private T data;
    private ResponseEnum status;
    private String mes;
    public void thanhcong(T data){
        setData(data);
        setStatus(ResponseEnum.THANHCONG);
        setMes("");
    }
    public void thatBai(T data, String mes){
        setData(data);
        setStatus(ResponseEnum.THATBAI);
        setMes(mes);
    }
    public void thanhcong(T data, String mes){
        setData(data);
        setStatus(ResponseEnum.THANHCONG);
        setMes(mes);
    }

}

