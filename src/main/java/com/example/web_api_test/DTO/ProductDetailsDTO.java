package com.example.web_api_test.DTO;

import com.example.web_api_test.models.ProductDetailPropertyDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailsDTO {
    private int ProductDetailId;
    private String ProductDetailName;
    private int Quantity;
    private float Price;
    private float ShellPrice;
    private int ParentId;
}
