package com.example.demo.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employee.Employee;
import com.example.demo.service.ServiceInterface;

@RestController("/welcome")
public class RestControllerPcf {
	
		@Autowired
		ServiceInterface empService;

		@RequestMapping(value = "/employees", method = RequestMethod.GET)
		public List<Employee> firstPage() {

			return empService.getAllEmployees();

		}

	}
	