package com.example.web_api_test.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "properties")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PropertyId;
    private int ProductId;
    @ManyToOne
    @JoinColumn(name = "ProductId", insertable = false, updatable = false)
    @JsonBackReference
    private Products products;
    private String PropertyName;
    private int PropertySort;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "properties", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<PropertyDetails> propertyDetails;
}
