package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Product;
@Repository
public interface ProductDAO extends JpaRepository<Product, Integer>{

}
