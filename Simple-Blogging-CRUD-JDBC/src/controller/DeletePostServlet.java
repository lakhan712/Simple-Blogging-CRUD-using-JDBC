package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DeletePost;

/**
 * Servlet implementation class DeletePostServlet
 */
@WebServlet("/DeletePostServlet")
public class DeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			
			if(request.getParameter("id")==null) {
				response.sendRedirect("home.jsp");
			}
//			System.out.println("UserID: "+user.getId());
//			System.out.println("Post data: "+request.getParameter("postdata"));
			System.out.println("we are in delete post");

			if (DeletePost.deletePost(Integer.parseInt(request.getParameter("id")))) {
				//session.setAttribute("ADDED", "Post Added successfully...");
				//response.sendRedirect("home.jsp");
				request.getRequestDispatcher("/HomeServlet").forward(request, response);
			} else {
				response.sendRedirect("home.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
