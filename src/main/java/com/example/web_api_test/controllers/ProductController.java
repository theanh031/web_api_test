package com.example.web_api_test.controllers;

import com.example.web_api_test.services.Impl.ProductService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "api/version1.0/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
        }
    }).create();
}
