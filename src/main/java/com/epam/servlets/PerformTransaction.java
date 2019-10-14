package main.java.com.epam.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.java.com.epam.enums.AccountStatus;
import main.java.com.epam.enums.TransactionType;
import main.java.com.epam.exceptions.IllegalAmountException;
import main.java.com.epam.exceptions.InsufficientAmountException;
import main.java.com.epam.model.Account;
import main.java.com.epam.model.Transaction;
import main.java.com.epam.service.AccountService;
import main.java.com.epam.service.TransactionService;
import main.java.com.epam.utils.CreateAService;

/**
 * The Class PerformTransaction.
 *
 * @author Manas
 * Servlet implementation class PerformTransaction.
 */
@WebServlet("/PerformTransaction")
public class PerformTransaction extends HttpServlet {
	
	/** The i. */
	static long transactionNum=0;
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
       
    /**
     * Instantiates a new perform transaction.
     *
     * @see HttpServlet#HttpServlet()
     */
    public PerformTransaction() {
        super();
    }


	/**
	 * Receives parameters from the transaction.jsp and forwards to transaction.jsp
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		transactionNum++;
		long accnum = Long.parseLong(request.getParameter("accnum"));
		double amount = Double.parseDouble(request.getParameter("amount"));
		TransactionType transactionType = TransactionType.valueOf(request.getParameter("transactionType"));
		CreateAService create = CreateAService.getInstance();
		TransactionService transactionServiceObject = create.getTransactionService();
		AccountService accServ = create.getAccService();
		Account acc = accServ.getDetails(accnum);
		if(transactionType==TransactionType.DEPOSIT && 	acc.getAccountStatus()==AccountStatus.ACTIVE)
		{
			try {
				transactionServiceObject.deposit(acc, amount,transactionNum);
				Transaction fetchedTransaction = transactionServiceObject.getDetails(transactionNum);
				request.getSession().setAttribute("transactiondata",fetchedTransaction);
				request.getSession().setAttribute("account",acc);
				response.sendRedirect("Transaction.jsp?result=1");
			} catch (IllegalAmountException e) {
				e.printStackTrace();
				response.getWriter().print("Enter amount greater than zero");
			}
			
		}
		else if(transactionType==TransactionType.WITHDRAW && (acc.getAccountStatus()==AccountStatus.ACTIVE)) {
			try {
				transactionServiceObject.withdraw(acc, amount,transactionNum);
				Transaction fetchedTransaction = transactionServiceObject.getDetails(transactionNum);
				request.getSession().setAttribute("transactiondata",fetchedTransaction);
				request.getSession().setAttribute("account",acc);
				response.sendRedirect("Transaction.jsp?result=1");
			} catch (IllegalAmountException | InsufficientAmountException e) {
				e.printStackTrace();
				response.getWriter().print("Enter amount greater than zero and less than balance");
			}
		}
		else {
			response.sendRedirect("Transaction.jsp?result=0");
		}
	}

}
