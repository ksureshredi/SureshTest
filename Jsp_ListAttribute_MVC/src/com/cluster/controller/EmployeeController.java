package com.cluster.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cluster.bean.Employee;
import com.cluster.service.EmployeeService;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/employee")
public class EmployeeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the request type and param
		String type  = request.getParameter("emp");		
		EmployeeService service = new EmployeeService();
		List<Employee> list =null;
		if(type.equalsIgnoreCase("Get Employee")){
			int empno = Integer.parseInt(request.getParameter("empno"));
			try {
				Employee emp = service.getEmployee(empno);
				request.setAttribute("emp", emp);
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/employee.jsp");
				rd.forward(request, response);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
		try {
			list = service.getAllEmployees();
			request.setAttribute("empList", list);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/employeesList.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
