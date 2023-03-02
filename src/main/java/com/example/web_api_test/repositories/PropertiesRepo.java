package com.example.web_api_test.repositories;

import com.example.web_api_test.models.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepo extends JpaRepository<Properties, Integer> {
}
