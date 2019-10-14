package main.java.com.epam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.enums.AccountType;
import main.java.com.epam.model.User;
import main.java.com.epam.service.UserService;
import main.java.com.epam.utils.CreateAService;

/**
 * @author Manas Servlet implementation class UserServlet.
 */
@WebServlet(name = "userServlet", urlPatterns = "/UserServlet")
public class UserServlet extends HttpServlet {

	/** The i. */
	static long userNum = 0;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new user servlet.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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
		userNum++;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String city = request.getParameter("city");
		String gender = request.getParameter("gender");
		AccountType accountType = AccountType.valueOf(request.getParameter("acctype"));
		String[] args = { firstName, lastName, city, gender, Long.toString(userNum), accountType.toString() };
		CreateAService create = CreateAService.getInstance();
		UserService userService = create.getUserService();
		boolean flag = userService.create(args);
		response.setContentType("text/html");
		PrintWriter pr = response.getWriter();
		if (flag) {
			User user = userService.getDetails(userNum);
			request.getSession().setAttribute("userdata", user);
			response.sendRedirect("DisplayUserDetails.jsp?result=1");
		} else {
			pr.append("no user created");
		}
	}

}
