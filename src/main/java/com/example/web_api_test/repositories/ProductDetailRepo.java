package com.example.web_api_test.repositories;

import com.example.web_api_test.models.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailRepo extends JpaRepository<ProductDetails, Integer> {
    @Query(nativeQuery = true, value = "Select * from productdetails " +
            " where ParentId is not null and ParentId not in (select ProductDetailId from productdetails where ParentId is null)")
    List<ProductDetails> selectAll();
}
