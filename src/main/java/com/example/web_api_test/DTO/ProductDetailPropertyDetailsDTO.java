package com.example.web_api_test.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailPropertyDetailsDTO {

    private int ProductDetailPropertyDetailId;
    private int ProductDetailId;
    private int PropertyDetailId;
    private int ProductId;
}
