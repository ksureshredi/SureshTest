<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<table border="2" align="center">
		 <tr> <th> Employee Id </th> <th> Employee Name </th> <th> Job </th> </tr>
		 <tr><td> ${requestScope.emp.empno} </td>
		 <td> ${requestScope.emp.ename} </td>
		 <td> ${requestScope.emp.job} </td>
		 </tr>
		</table>
</body>
</html>