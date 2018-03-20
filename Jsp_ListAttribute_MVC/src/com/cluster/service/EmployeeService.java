package com.cluster.service;

import java.sql.SQLException;
import java.util.List;

import com.cluster.bean.Employee;
import com.cluster.dao.EmployeeDao;

public class EmployeeService {
	EmployeeDao dao = new EmployeeDao();
	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException{
		List<Employee> list = dao.getAllEmployees();
		return list;
	}
	public Employee getEmployee(int empno) throws ClassNotFoundException, SQLException{
		Employee emp = dao.getEmployee(empno);
		return emp;
	}
}
