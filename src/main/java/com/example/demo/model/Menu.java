package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "menu")
@Getter
@Setter
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private long price;



    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "food_name")
    private String foodName;


    @OneToOne(mappedBy = "menu", fetch = FetchType.LAZY)
    @JsonIgnore
    private Offers offers;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    private Category category;
}
