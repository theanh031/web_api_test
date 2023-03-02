package com.example.web_api_test.controllers;

import com.example.web_api_test.DTO.ProductDetailPropertyDetailsDTO;
import com.example.web_api_test.DTO.ProductDetailsDTO;
import com.example.web_api_test.services.Impl.ProductDetailPropertyDetailService;
import com.google.gson.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
@RequestMapping(value = "api/version1.0/PDPD/")
public class ProductDetailPropertyDetailsController {
    @Autowired
    private ProductDetailPropertyDetailService productDetailPropertyDetailService;
    private Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
        @Override
        public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDate.parse(json.getAsJsonPrimitive().getAsString());
        }
    }).create();

    @PutMapping("")
    com.phieuthu_lts.comon.Enum.Response<ProductDetailsDTO> addToCart(@RequestParam Integer productID,
                                                                      @RequestParam Integer propertyId_1,
                                                                      @RequestParam Integer propertyId_2,
                                                                      @RequestParam(required = false) Integer propertyId_3,
                                                                      @RequestParam Integer quantityProduct){
        if(propertyId_3 == null) {
            return  productDetailPropertyDetailService.addToCart(productID, propertyId_1, propertyId_2, quantityProduct);
        }
        return productDetailPropertyDetailService.addToCart(productID, propertyId_1, propertyId_2, propertyId_3, quantityProduct);
    }

    @PutMapping("update")
    com.phieuthu_lts.comon.Enum.Response<ProductDetailsDTO> updateProduct(@RequestParam Integer productID,
                                                                          @RequestParam Integer propertyId_1,
                                                                          @RequestParam Integer propertyId_2,
                                                                          @RequestParam(required = false) Integer propertyId_3,
                                                                          @RequestParam Integer quantityProduct) {
        if(propertyId_3 == null) {
            return productDetailPropertyDetailService.updateProduct(productID, propertyId_1, propertyId_2, quantityProduct);
        }
        return productDetailPropertyDetailService.updateProduct(productID, propertyId_1, propertyId_2, propertyId_3, quantityProduct);
    }



}
