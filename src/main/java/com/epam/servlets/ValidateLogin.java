package main.java.com.epam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * The Class ValidateLogin.
 *
 * @author Manas
 *
 */
@WebServlet("/ValidateLogin")
public class ValidateLogin extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new validate login.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public ValidateLogin() {
		super();
	}

	/**
	 * Do post.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		if (request.getParameter("userId").equals("mihir") && request.getParameter("password").equals("1234")) {
			HttpSession newSession = request.getSession();
			newSession.setAttribute("userid", request.getParameter("userId"));
			response.sendRedirect("NewUser.jsp");
		} else if (request.getParameter("userId").equals("mihir")) {
			pr.append("wrong password");
		} else {
			response.sendRedirect("Login.jsp");
		}
	}

}
