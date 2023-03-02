package com.example.web_api_test.services;

import com.example.web_api_test.DTO.ProductDetailPropertyDetailsDTO;
import com.example.web_api_test.DTO.ProductDetailsDTO;

import java.util.Map;

public interface IProductDetailPropertyDetailService {
    com.phieuthu_lts.comon.Enum.Response<ProductDetailsDTO> addToCart(int productID, int propertyId_1, int propertyId_2, int propertyId_3, int quantityProduct);
    com.phieuthu_lts.comon.Enum.Response<ProductDetailsDTO> addToCart(int productID, int propertyId_1, int propertyId_2, int quantityProduct);
    com.phieuthu_lts.comon.Enum.Response<ProductDetailsDTO> updateProduct(int productID, int propertyId_1, int propertyId_2, int propertyId_3, int quantityProduct);
    com.phieuthu_lts.comon.Enum.Response<ProductDetailsDTO> updateProduct(int productID, int propertyId_1, int propertyId_2, int quantityProduct);
}
