package com.techm.gmsBackend.dao;

import com.techm.gmsBackend.entity.GymPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PackageRepository extends JpaRepository<GymPackage, Long>{
	
}
