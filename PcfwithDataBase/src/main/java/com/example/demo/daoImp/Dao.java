package com.example.demo.daoImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.DaoInterface;
import com.example.demo.employee.Employee;


@Repository
public class Dao extends JdbcDaoSupport implements DaoInterface{


		@Autowired
		DataSource dataSource;

		@PostConstruct
		private void initialize() {
			setDataSource(dataSource);
		}
        @Override
		public List<Employee> getAllEmployees() {
			String sql = "SELECT * FROM employee";
			List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

			List<Employee> result = new ArrayList<Employee>();
			for (Map<String, Object> row : rows) {
				Employee emp = new Employee();
				emp.setEmpId((String) row.get("empId"));
				emp.setEmpName((String) row.get("empName"));
				result.add(emp);
			}

			return result;
		}
	}


