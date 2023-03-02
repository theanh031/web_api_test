package com.example.web_api_test.repositories;

import com.example.web_api_test.models.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailRepo extends JpaRepository<PropertyDetails, Integer> {
}
