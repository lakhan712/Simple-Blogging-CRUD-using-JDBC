<% request.setAttribute("title", "Registration page"); %>
<%@include file="header.jsp"%>

<%
	String msg = "";
if (session.getAttribute("ERROR") != null) {
	msg = session.getAttribute("ERROR").toString();
}
%>

<body>
	<div class="container-fluid">

		<div class="row">
			<!--  <div class="col-12 bg-danger" style="height:100vh;">-->

			<div
				class="col-12 bg-dark text-light d-flex justify-content-center align-items-center"
				style="height: 100vh;">


				<!-- FORM IS CREATED HERE AND REQUEST IS PASSES TO REGISTER SERVLET -->

				<form action="register" method="post">
					<div class="form-group">
						<label>Usersname:</label> <input type="text" name="username"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Password</label> <input type="password" name="password"
							class="form-control">
					</div>

					<div class="form-group">
						<label>Email address:</label> <input type="email" name="email"
							class="form-control" aria-describedby="emailHelp">
					</div>

					<div class="form-group">
						<label>Mobile:</label> <input type="number" name="mobile"
							class="form-control">
					</div>

					<button type="submit" class="btn btn-success">Register</button>
					<a href="index.jsp" class="btn btn-secondary" role="button"
						aria-pressed="true">Login</a> <br/><br/>
						<% if(msg!="") {%>
						
						<div class="alert alert-danger" role="alert"> <%=msg %></div>
						<% session.removeAttribute("ERROR");}
						
						%>
						
				</form>
			</div>
		</div>
	</div>


</body>
</html>