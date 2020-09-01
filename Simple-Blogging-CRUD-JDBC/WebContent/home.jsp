<%@page import="model.User"%>
<%@page import="model.Post"%>
<%@page import="java.util.List" %>
<% request.setAttribute("title", "Home page"); %>
<%@include file="header.jsp"%>
<%
	User user = null;
	List<Post> posts=null;
	
if (session.getAttribute("AUTH") == null) {
	
	response.sendRedirect("index.jsp");
	return;
} else if (session.getAttribute("User") == null) {
	
	response.sendRedirect("index.jsp");
	return;
} else if(session.getAttribute("posts") == null) {
	
	response.sendRedirect("index.jsp");
	return;
}else{
	 user = (User) session.getAttribute("User");
	 posts = (List<Post>) session.getAttribute("posts");
	
}
/*
if (session.getAttribute("ADDED") != null) {
	System.out.println("Added is null");
	msg = session.getAttribute("ADDED").toString();
} else {
	response.sendRedirect("index.jsp");
} */
%>
<body>

	<div class="container-fluid">
		<div class="row">
			<div class="col-6 bg-dark text-light d-flex align-items-center"
				style="height: 60px">Home Demo-Crud</div>
			<div
				class="col-6 bg-dark text-light d-flex justify-content-end align-items-center"
				style="height: 60px">
				<a class="btn btn-danger" href="Logout" role="button">Logout</a>
			</div>
		</div>
	</div>



	<h4>
		Welcome
		<%=user.getUsername()%>
		to home page
	</h4>
	<br>
	<br>

	<div class="row">
		<div class="col-3"></div>
		<div class="col-6 bg-secondary d-flex align-items-center"
			style="height: 80px">

			<!-- POST FORM -->
			<form class="col-12" action="PostServlet" method="post">
				<div class="form-row">
					<div class="col-10">
						<input class="form-control form-control-lg" type="text"
							name="postdata" placeholder="Post Something...">
					</div>
					<div class="col-2">
						<button type="submit" class="btn btn-dark ml-1">POST</button>
					</div>
				</div>
			</form>
		</div>
	</div>


<!-- Main Post data started from here... -->
<%
for(Post post: posts){
%>

	<div class="row mt-1">
		<div class="col-3 "></div>
		<div class="col-6">

			<div class="card">
				<div class="card-header">Your Post <%=post.getId() %> : </div>
				<div class="card-body">
					<h5 class="card-title"><%=post.getPost()%></h5>
					<p class="card-text">Likes: <%=post.getLikeCount()%> and Dislikes: <%=post.getDislikeCount()%></p>
				
				
					<form class="col-12" action="DeletePostServlet?id=<%=post.getId()%>" method="post">
				<div class="form-row">
				<div class="col-12">
					
					
						<button type="submit" class="btn btn-danger ml-1">Delete</button>
						<a href="update.jsp?id=<%=post.getId()%>" class="btn btn-warning" role="button">Update</a>
						</div>
			
				</div>
			</form>
			
			
				
				</div>
			</div>

		</div>
	</div>

<%} %>



</body>





</html>