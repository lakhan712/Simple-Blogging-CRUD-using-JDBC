package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AuthenticationService;

/**
 * Servlet implementation class HBLoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			HttpSession session = request.getSession();
			if (request.getParameter("username").equals("") && request.getParameter("username").equals("")) {
				session.setAttribute("EMPTY", "please fill the blank");
				response.sendRedirect("index.jsp");
				return;
			} else {
				if (AuthenticationService.valideateUser(request.getParameter("username"),
						request.getParameter("password"))) {

					session.setAttribute("User", AuthenticationService.getUser());
					System.out.println("Login is Successful...");
					session.setAttribute("AUTH", true);
					System.out.println("AUTH is set...");
					System.out.println("Request Forwarding to HomeServlet...");

					request.getRequestDispatcher("/HomeServlet").forward(request, response);
					// response.sendRedirect("home.jsp");
				} else {
					session.setAttribute("EMPTY", "Username and Password are invalid...");
					response.sendRedirect("index.jsp");
					return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		doGet(request, response);
	}

}
