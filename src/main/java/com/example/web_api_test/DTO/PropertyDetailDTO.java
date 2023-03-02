package com.example.web_api_test.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyDetailDTO {
    private int PropertyDetailId;
    private int PropertyId;
    private String PropertyDetailCode;
    private String PropertyDetailDetail;
}
