package com.techm.gmsBackend.service;

import java.util.List;

import com.techm.gmsBackend.entity.GymPackage;
import org.springframework.stereotype.Service;

import com.techm.gmsBackend.dao.PackageRepository;

@Service
public class PackageService {
	private final PackageRepository packageRepository;

	public PackageService(PackageRepository packageRepository) {
		this.packageRepository = packageRepository;
	}

	public String createOrUpdatePackage(GymPackage packages) {
		packageRepository.save(packages);
		return "package created";
	}

	public List<GymPackage> getAllPackages() {
		return packageRepository.findAll();
	}

	public GymPackage getPackage(long id) {
		return packageRepository.findById(id).orElse(null);
	}

	public String deletePackage(long id) {
		packageRepository.deleteById(id);
		return "package deleted";
	}

}
