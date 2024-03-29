package com.example.springboot.project0.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.springboot.project0.entity.Department;
import com.example.springboot.project0.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
public class DepartmentController {
	
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/departments")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return departmentService.saveDepartment(department);
		}
	@GetMapping("/departments")
	public  List<Department> fetchDepartmentList(){
	return departmentService.fetchDepartmentList();	
	}
	@GetMapping("/departments/{id}")
	public Department fetchDepartmentById(@PathVariable("id")Long departmentId) {
		return departmentService.fetchDepartmentById(departmentId);
}
	@DeleteMapping("/departments/{id}")
	public String deleteDepartmentById(@PathVariable("id")Long departmentId) {
		departmentService.deletedepartmentById(departmentId);
		return "Department deleted Successfully !!";
		
}
	@PutMapping("/departments/{id}")
	public Department updateDepartment(@PathVariable("id")Long departmentId,@RequestBody Department department) {
      return departmentService.updateDepartment(departmentId,department);
	}
	@GetMapping("/departments/name/{name}")
	public Department fetchDepartmentByName(@PathVariable("name")String departmentName) {
		return departmentService.fetchDepartmentByName(departmentName);
	}
}


