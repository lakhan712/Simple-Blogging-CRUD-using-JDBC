<% request.setAttribute("title", "Login page"); %>
<%@include file="header.jsp"%>

<%
	String msg = "";
if (session.getAttribute("EMPTY") != null) {
	msg = session.getAttribute("EMPTY").toString();
}
%>

<body>

	<div class="container-fluid">
		<div class="row">
			<div
				class="col-12 bg-dark text-light d-flex justify-content-center align-items-center"
				style="height: 100vh;">

				<form action="LoginServlet" method="post">
					<div class="form-group">
						<label>Usersname:</label> <input type="text" name="username"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password" name="password"
							class="form-control">
					</div>

					<button type="submit" class="btn btn-primary">Login</button>
					<a href="register.jsp" class="btn btn-secondary" role="button"
						aria-pressed="true">Register</a><br/><br/>
						<% if(msg!="") {%>
							
						<div class="alert alert-danger mt-1" role="alert"> <%=msg %></div>
						<% session.removeAttribute("EMPTY");  }     %>
				</form>

			</div>
		</div>
	</div>

</body>
</html>