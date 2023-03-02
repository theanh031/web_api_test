package com.example.web_api_test.services.Impl;

import com.example.web_api_test.repositories.PropertiesRepo;
import com.example.web_api_test.services.IPropertyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService implements IPropertyService {
    @Autowired
    private PropertiesRepo propertiesRepo;

}
