package com.example.web_api_test.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productdetailpropertydetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetailPropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductDetailPropertyDetailId;
    private int ProductDetailId;
    @ManyToOne
    @JoinColumn(name = "ProductDetailId",insertable = false, updatable = false)
    @JsonBackReference
    private ProductDetails productDetails;
    private int PropertyDetailId;
    @ManyToOne
    @JoinColumn(name = "PropertyDetailId",insertable = false, updatable = false)
    @JsonBackReference
    private PropertyDetails propertyDetails;
    private int ProductId;
    @ManyToOne
    @JoinColumn(name = "ProductId", insertable = false, updatable = false)
    private Products products;

}
