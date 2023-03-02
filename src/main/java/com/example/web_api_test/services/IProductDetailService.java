package com.example.web_api_test.services;

import com.example.web_api_test.DTO.ProductDetailsDTO;

import java.util.List;

public interface IProductDetailService {
    com.phieuthu_lts.comon.Enum.Response<List<ProductDetailsDTO>> selectAllTable();

}
