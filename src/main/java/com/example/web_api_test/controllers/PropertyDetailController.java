package com.example.web_api_test.controllers;

import com.example.web_api_test.services.Impl.PropertyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertyDetailController {
    @Autowired
    private PropertyDetailService propertyDetailService;
}
