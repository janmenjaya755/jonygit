package com.example.demo.serviceImp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.DaoInterface;

import com.example.demo.employee.Employee;
import com.example.demo.service.ServiceInterface;

@Service
public class ServiceLayer implements ServiceInterface {
	

		@Autowired
		DaoInterface employeeDao;

		public List<Employee> getAllEmployees() {
			List<Employee> employees = employeeDao.getAllEmployees();
			return employees;
		}

	}


