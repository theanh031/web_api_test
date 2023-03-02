package com.example.web_api_test.repositories;

import com.example.web_api_test.models.ProductDetailPropertyDetails;
import com.example.web_api_test.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDetailPropertyDetailsRepo extends JpaRepository<ProductDetailPropertyDetails, Integer> {
    @Query(nativeQuery = true, value = "select ProductDetailId from productdetailpropertydetails " +
            "where ProductId =:productId and PropertyDetailId =:propertyDetailId")
    List<Integer> ProductDetailId_List(int productId, int propertyDetailId);


}
