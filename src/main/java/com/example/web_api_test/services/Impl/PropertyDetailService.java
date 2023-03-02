package com.example.web_api_test.services.Impl;

import com.example.web_api_test.repositories.PropertyDetailRepo;
import com.example.web_api_test.services.IPropertyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyDetailService implements IPropertyDetailService {
    @Autowired
    private PropertyDetailRepo propertyDetailRepo;
}
