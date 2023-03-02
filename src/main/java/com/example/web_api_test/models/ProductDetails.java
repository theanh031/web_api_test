package com.example.web_api_test.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.lang.Nullable;

import java.util.Set;

@Entity
@Table(name = "productdetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ProductDetailId;
    private String ProductDetailName;
    private Integer Quantity;
    private Float Price;
    private Float ShellPrice;
    @Column(nullable = true)
    private Integer ParentId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productDetails", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<ProductDetailPropertyDetails> productDetailPropertyDetails;

    @OneToOne
    @JoinColumn(name = "ParentId", insertable = false, updatable = false, nullable = true)
    private ProductDetails ProductDetails;

}
