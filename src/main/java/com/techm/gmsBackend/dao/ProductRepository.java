package com.techm.gmsBackend.dao;

import com.techm.gmsBackend.entity.GymProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<GymProduct, Long> {

}
