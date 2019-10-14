package main.java.com.epam.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import main.java.com.epam.enums.AccountStatus;
import main.java.com.epam.model.Account;
import main.java.com.epam.utils.CreateAService;

/**
 * The Class ActiveToggle.
 *
 * @author Manas
 * 
 */
@WebServlet("/ActiveToggle")
public class ActiveToggle extends HttpServlet {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor for ActiveToggle.
	 */
	public ActiveToggle() {
		super();
	}

	/**
	 * doGet method receives requests and forwards requests.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException      Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		long accountNum = Long.parseLong(request.getParameter("accNum"));
		CreateAService create = CreateAService.getInstance();
		Account account = create.getAccService().getDetails(accountNum);
		int operation = Integer.parseInt(request.getParameter("opr"));
		if (operation == 1) {
			account.setAccountStatus(AccountStatus.INACTIVE);
			request.setAttribute("account", account);
			response.sendRedirect("DisplayAccount?accNum=" + accountNum);
		} else {
			account.setAccountStatus(AccountStatus.ACTIVE);
			request.setAttribute("account", account);
			response.sendRedirect("DisplayAccount?accNum=" + accountNum);
		}
	}

}
