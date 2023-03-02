package com.example.web_api_test.DTO;

import com.example.web_api_test.models.ProductDetailPropertyDetails;
import com.example.web_api_test.models.Properties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsDTO {
    private int ProductId;
    private String ProductName;
    private Set<Properties> Properties;
    private Set<ProductDetailPropertyDetails> productDetailPropertyDetails;
}
