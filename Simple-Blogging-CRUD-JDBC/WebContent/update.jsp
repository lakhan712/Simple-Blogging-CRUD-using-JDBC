<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.List" %>
<%@page import="model.Post"%>
<% request.setAttribute("title", "Update page"); %>
<%@include file="header.jsp"%>
<%
	List<Post> posts=null;
	
	int id = Integer.parseInt(request.getParameter("id"));
	
	
if (session.getAttribute("AUTH") == null) {
	
	response.sendRedirect("index.jsp");
	return;
} else if(session.getAttribute("posts") == null) {
	
	response.sendRedirect("index.jsp");
	return;
}else if(id == 0){
	response.sendRedirect("index.jsp");
}else{
	 
	 posts = (List<Post>) session.getAttribute("posts");
	
}

%>
    
    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-6 bg-dark text-light d-flex align-items-center"
				style="height: 60px">Update Post</div>
			<div
				class="col-6 bg-dark text-light d-flex justify-content-end align-items-center"
				style="height: 60px">
				<a class="btn btn-danger" href="Logout" role="button">Logout</a>
			</div>
		</div>
	</div>
	
	<h4>
		Welcome to post update page...
	</h4>
	<br>
	<br>


<% 

for(Post post: posts){
	
	if(post.getId()==id){
			
		%>
		
		<div class="row">
		<div class="col-3"></div>
		<div class="col-6 bg-secondary d-flex align-items-center"
			style="height: 80px">

			<!-- POST FORM -->
			<form class="col-12" action="PostUpdateServlet" method="post">
				<div class="form-row">
					<div class="col-10">
						<input class="form-control form-control-lg" type="text"
							name="post" placeholder="<%=post.getPost()%>">
						<input type="hidden" name="id" value="<%=id%>">
					</div>
					<div class="col-2">
						<button type="submit" class="btn btn-dark ml-1">Update</button>
					</div>
				</div>
			</form>
		</div>
	</div>
	
		
		<% 
		
	}
};


%>

</body>
</html>