package com.example.web_api_test.controllers;

import com.example.web_api_test.DTO.ProductDetailsDTO;
import com.example.web_api_test.services.Impl.ProductDetailService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(value = "api/version1.0/ProductDetail")
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;
    private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
        }
    }).create();


    @GetMapping("")
    com.phieuthu_lts.comon.Enum.Response<List<ProductDetailsDTO>> selectAllTable(){
        return productDetailService.selectAllTable();
    }

}
