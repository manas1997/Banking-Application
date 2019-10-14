package main.java.com.epam.servlets;

import java.io.IOException;
import java.util.NoSuchElementException;

import javax.servlet.RequestDispatcher;
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
 * The Class AddAccount.
 *
 * @author Manas
 * 
 */
@WebServlet("/AddAccount")
public class AddAccount extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new adds the account.
	 *
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAccount() {
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
		CreateAService create = CreateAService.getInstance();
		UserService userService = create.getUserService();
		RequestDispatcher requestDispatch;
		try {
			User user = userService.getDetails(Long.parseLong(request.getParameter("userNumber")));
			userService.addAccountToUser(AccountType.CURRENT, user);
			requestDispatch = request.getRequestDispatcher("/ListOfOperations.jsp");
			requestDispatch.forward(request, response);
		} catch (NoSuchElementException e) {
			requestDispatch = request.getRequestDispatcher("/AddAccountToUser.jsp");
			requestDispatch.forward(request, response);
		}

	}

}
