package com.cluster.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cluster.bean.Employee;
import com.cluster.util.DbConnection;

public class EmployeeDao {
	static final String SQL = "SELECT EMPNO,ENAME,JOB FROM EMP";
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	Employee emp = null;
	public List<Employee> getAllEmployees() throws ClassNotFoundException, SQLException{
		List<Employee> list = new ArrayList<>();
		con = DbConnection.getConnection();
		// create the preparedStatement
		ps = con.prepareStatement(SQL);
		// execute the query
		rs = ps.executeQuery();
		if(rs!=null){
			while(rs.next()){
				emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				list.add(emp);
			}
		}
		return list;
		
	}
	public Employee getEmployee(int empno) throws ClassNotFoundException, SQLException{
		con = DbConnection.getConnection();
		ps = con.prepareStatement("SELECT EMPNO,ENAME,JOB FROM EMP WHERE EMPNO = ?");
		ps.setInt(1, empno);
		rs = ps.executeQuery();
		if(rs!=null){
			if(rs.next()){
				emp = new Employee();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
			}
		}
		return emp;
		
	}
	
}
