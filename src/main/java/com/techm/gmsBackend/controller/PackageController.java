package com.techm.gmsBackend.controller;

import java.util.List;

import com.techm.gmsBackend.entity.GymPackage;
import org.springframework.web.bind.annotation.*;

import com.techm.gmsBackend.service.PackageService;

@RestController
@RequestMapping("/v1/packages")
public class PackageController {
	private final PackageService packageService;
	public PackageController(PackageService packageService) {
		this.packageService = packageService;
	}
	@PostMapping("/add")
	public String addPackage(@RequestBody GymPackage packages) {
		return packageService.createOrUpdatePackage(packages);
	}
	@PutMapping ("/update")
	public String updatePackage(@RequestBody GymPackage packages) {
		return packageService.createOrUpdatePackage(packages);
	}
	@GetMapping("/get-all")
	public List<GymPackage> getAllPackage(){
		return packageService.getAllPackages();
	}
	@GetMapping("/get-id/{id}")
	public GymPackage getPackageById(@PathVariable long id) {
		return packageService.getPackage(id);
	}
	@DeleteMapping("/delete-id/{id}")
	public String deleteById(@PathVariable long id) {
		return packageService.deletePackage(id);
	}
}
