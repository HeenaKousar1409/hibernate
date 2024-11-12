<%@page import="spring_mvc_dto.EmployeeDto"%>
<%@page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% List<EmployeeDto> l=(List<EmployeeDto>)request.getAttribute("abc");%>
<table border="3px">
<tr>
<th>name</th>
<th>id</th>
</tr>
<%for(EmployeeDto a :l){ %>
<tr>
<td><%=a.getName() %></td>
<td><%=a.getId() %></td>
<%} %>
</tr>
</table>
</body>
</html>