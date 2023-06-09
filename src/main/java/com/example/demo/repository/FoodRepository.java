package com.example.demo.repository;

import com.example.demo.model.Foods;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Foods, Long> {
}
