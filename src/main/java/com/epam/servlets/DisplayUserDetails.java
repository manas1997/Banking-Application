package main.java.com.epam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.model.User;
import main.java.com.epam.utils.CreateAService;

/**
 * The Class DisplayUserDetails.
 *
 * @author Manas
 * 
 */
@WebServlet("/DisplayUserDetails")
public class DisplayUserDetails extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new display user details.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayUserDetails() {
		super();
		// TODO Auto-generated constructor stub
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
		long userId = Long.parseLong(request.getParameter("userId"));
		CreateAService create = CreateAService.getInstance();
		User createdUser = create.getUserService().getDetails(userId);
		if (createdUser != null) {
			request.getSession().setAttribute("userdata", createdUser);
			response.sendRedirect("DisplayUserDetails.jsp?result=1");
		} else if (createdUser == null) {
			response.sendRedirect("DisplayUserDetails.jsp?result=0");
		}
	}

}
