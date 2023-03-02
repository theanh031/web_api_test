package com.example.web_api_test.DTO;

import com.example.web_api_test.models.PropertyDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertiesDTO {
    private int PropertyId;
    private int ProductId;
    private String PropertyName;
    private int PropertySoft;
    private Set<PropertyDetails> propertyDetails;

}
