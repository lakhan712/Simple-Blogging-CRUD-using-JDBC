package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RegisterService;
import model.User;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/register")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// response.getWriter().append("Served at: ").append(request.getContextPath());
		// REDIRECTING TO index.jsp PAGE...
		try {
		if (request.getAttribute("data").toString() == null) {
			request.getRequestDispatcher("register.jsp").forward(request, response);
			//response.sendRedirect("register.jsp");
		} else {
			//System.out.println(request.getAttribute("data").toString());
			response.sendRedirect("show");
			return;
		}
		}catch(Exception e) {
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		try {

		// CHECKING IF FIELD IS EMPTY OR NOT...
		if (request.getParameter("username").equals("")) {
			request.setAttribute("error", "username is empty");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else if (request.getParameter("password").equals("")) {
			request.setAttribute("error", "password is empty");
			request.getRequestDispatcher("/register.jsp").forward(request, response);

		} else if (request.getParameter("email").equals("")) {
			request.setAttribute("error", "email is empty");
			request.getRequestDispatcher("register.jsp").forward(request, response);

		} else if (request.getParameter("mobile").equals("")) {
			request.setAttribute("error", "mobile is empty");
			request.getRequestDispatcher("register.jsp").forward(request, response);

		} else {
			// IF EVERY FIELD IS FILLED WE ARE ADDING DATA IN USER INSTANCE
			User user = new User();
			user.setUsername(request.getParameter("username"));
			user.setPassword(request.getParameter("password"));
			user.setEmail(request.getParameter("email"));
			user.setMobile(request.getParameter("mobile"));

			// PASSING USER INSTANCE TO REGISTER METHOD...
			RegisterService.register(user);
			request.setAttribute("data", "1");

		}

		// PASSING REQUEST AND RESPONSE TO DOGET() MOTHOD...
		doGet(request, response);
		}catch(Exception e) {
			session.setAttribute("ERROR", "Username already exist");
			e.printStackTrace();
			
			response.sendRedirect("register.jsp");
			return;
			
			
		}
	}

}
