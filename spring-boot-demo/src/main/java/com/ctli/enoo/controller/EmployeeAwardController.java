package com.ctli.enoo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.ctli.enoo.entity.EmployeeAward;
import com.ctli.enoo.service.IEmployeeAwardService;

@Controller
@RequestMapping("employeeAward")
public class EmployeeAwardController {
	@Autowired
	private IEmployeeAwardService employeeService;
	@GetMapping("/get/{id}")
	public ResponseEntity<EmployeeAward> getEmployeeById(@PathVariable("id") Integer id) {
		EmployeeAward employeeAward = employeeService.getEmployeeAwardById(id);
		return new ResponseEntity<>(employeeAward, HttpStatus.OK);
	}
	@GetMapping("/getAll")
	public ResponseEntity<List<EmployeeAward>> getAllEmployees() {
		List<EmployeeAward> list = employeeService.getAllEmployeeAwards();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	@PostMapping("/create")
	public ResponseEntity<Void> addEmployee(@RequestBody EmployeeAward employeeAward, UriComponentsBuilder builder) {
        boolean flag = employeeService.addEmployeeAward(employeeAward);
        if (!flag) {
        	return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/get/{id}").buildAndExpand(employeeAward.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<EmployeeAward> updateEmployee(@RequestBody EmployeeAward employeeAward) {
		employeeService.updateEmployeeAward(employeeAward);
		return new ResponseEntity<>(employeeAward, HttpStatus.OK);
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id) {
		employeeService.deleteEmployeeAward(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}	
} 