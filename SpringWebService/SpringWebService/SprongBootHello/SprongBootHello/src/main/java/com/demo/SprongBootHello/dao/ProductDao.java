package com.demo.SprongBootHello.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.SprongBootHello.beans.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer>{

}
