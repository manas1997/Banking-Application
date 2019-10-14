package main.java.com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.model.Account;
import main.java.com.epam.utils.CreateAService;

/**
 * The Class DisplayAccount.
 *
 * @author Manas
 * 
 */
@WebServlet("/DisplayAccount")
public class DisplayAccount extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new display account.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayAccount() {
		super();
	}

	/**
	 * Do get.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long accountNum = Long.parseLong(request.getParameter("accNum"));
		CreateAService create = CreateAService.getInstance();
		Account createdAccount = create.getAccService().getDetails(accountNum);
		if (createdAccount != null) {
			request.getSession().setAttribute("account", createdAccount);
			response.sendRedirect("DisplayAccountDetails.jsp?result=1");
		} else if (createdAccount == null) {
			response.sendRedirect("DisplayAccountsDetails.jsp?result=0");
		}
	}

}
