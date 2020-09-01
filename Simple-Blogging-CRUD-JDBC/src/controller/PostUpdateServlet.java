package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.PostService;
import model.UpdateService;
import model.User;

/**
 * Servlet implementation class PostUpdateServlet
 */
@WebServlet("/PostUpdateServlet")
public class PostUpdateServlet extends HttpServlet {
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
			HttpSession session = request.getSession();
			if(request.getParameter("post")==null || request.getParameter("post")== "" ) {
				response.sendRedirect("update.jsp");
			}
//			System.out.println("UserID: "+user.getId());
//			System.out.println("Post data: "+request.getParameter("postdata"));
			System.out.println("we are in update servlet");

			if (UpdateService.updatePost(request.getParameter("post"), Integer.parseInt(request.getParameter("id")))) {
				//session.setAttribute("ADDED", "Post Added successfully...");
				//response.sendRedirect("home.jsp");
				request.getRequestDispatcher("/HomeServlet").forward(request, response);
			} else {
				session.setAttribute("ADDED", "Something went wrong Post not Added...");
				response.sendRedirect("update.jsp");
				return;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
