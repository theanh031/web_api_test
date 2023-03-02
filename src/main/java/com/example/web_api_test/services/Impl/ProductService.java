package com.example.web_api_test.services.Impl;

import com.example.web_api_test.DTO.ProductsDTO;
import com.example.web_api_test.models.ProductDetailPropertyDetails;
import com.example.web_api_test.models.Products;
import com.example.web_api_test.repositories.ProductDetailPropertyDetailsRepo;
import com.example.web_api_test.repositories.ProductRepo;
import com.example.web_api_test.services.IProductService;
import com.phieuthu_lts.comon.Enum.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private ProductDetailPropertyDetailsRepo productDetailPropertyDetailsRepo;

}
