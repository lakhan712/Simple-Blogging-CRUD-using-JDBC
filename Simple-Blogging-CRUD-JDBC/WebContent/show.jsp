<%@page import="model.User"%>
<%@page import="java.util.List"%>
<% request.setAttribute("title", "Show page"); %>
<%@include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-6 bg-dark text-light d-flex align-items-center"
				style="height: 60px">Just to check other accounts credentials</div>
			<div
				class="col-6 bg-dark text-light d-flex justify-content-end align-items-center"
				style="height: 60px">
				<a class="btn btn-primary" href="index.jsp" role="button">Login</a>
			</div>
		</div>
	</div>
	<br><br>

	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Username</th>
				<th scope="col">Password</th>
				<th scope="col">Email</th>
				<th scope="col">Mobile</th>
			</tr>
		</thead>
		<tbody>

			<%
				try {

				//String data = request.getAttribute("test").toString();
				//out.print("we are in show "+data);  

				List<User> list = (List<User>) request.getAttribute("data");
				
				for (User user : list) {
			%>

			<tr>
				<th scope="row"><%=user.getId()%></th>
				<td><%=user.getUsername()%></td>
				<td><%=user.getPassword()%></td>
				<td><%=user.getEmail()%></td>
				<td><%=user.getMobile()%></td>
			</tr>



			<%
				}

			} catch (Exception e) {
				System.out.println(" exception occured..." + e);
			}
			%>

		</tbody>
	</table>
</body>
</html>