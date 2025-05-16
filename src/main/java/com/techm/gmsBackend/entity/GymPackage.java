package com.techm.gmsBackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="packages")
public class GymPackage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	 private  String packageName;
	 private long packagePrice;
	 private String profileUrl;
	 private String packageDesc;

	
}
