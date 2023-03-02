package com.example.web_api_test.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "propertydetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PropertyDetailId;
    private int PropertyId;
    private String PropertyDetailCode;
    private String PropertyDetailDetail;
    @ManyToOne
    @JoinColumn(name = "PropertyId", insertable = false, updatable = false)
    @JsonBackReference
    private Properties properties;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "propertyDetails", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ProductDetailPropertyDetails> productDetailPropertyDetails;

}
