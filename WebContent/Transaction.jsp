
<%@page import="main.java.com.epam.enums.AccountStatus"%>
<%@page import="main.java.com.epam.enums.TransactionType"%>
<%
	if (session != null) {
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("Login.jsp");
		}
	}
%>
<%@page import="main.java.com.epam.model.Transaction"%>
<%@page import="main.java.com.epam.model.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Transaction transaction = null;
	double balance = 0.0;
	Account account = null;
	boolean flag = false;
	int i = 5;
	if (request.getParameter("result") != null) {
		i = Integer.parseInt(request.getParameter("result"));
	}
	if (request.getMethod().equals("GET") && i == 1) {
		transaction = (Transaction) session.getAttribute("transactiondata");
		account = (Account) session.getAttribute("account");
		balance = account.getBalance();
		flag = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark fixed-top">
		<a class="navbar-brand" href="#"><img src="BankLogo.jpg"
			width="50px" height="50px"></a>
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="NewUser.jsp">Create
					a new User</a></li>
			<li class="nav-item"><a class="nav-link"
				href="DisplayUserDetails.jsp">Display User Details</a></li>
			<li class="nav-item"><a class="nav-link"
				href="AddAccountToUser.jsp">Add Account To User</a></li>
			<li class="nav-item"><a class="nav-link" href="Transaction.jsp">Transaction</a></li>
			<li class="nav-item"><a class="nav-link"
				href="DisplayAccountDetails.jsp">Account Details</a></li>
			<li class="nav-item">
				<div>
					<form action="Logout" method="post">

						<button type="submit" class="btn btn-danger" value="logout">Logout</button>
					</form>
				</div>
			</li>
		</ul>
	</nav>
	<br>
	<br>
	<br>
	<br>
	<h2 align="center">Transactions</h2>
	<br>
	<br>
	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<form method="post" action="PerformTransaction">
				<input type="text" class="form-control" placeholder="Account Number"
					name="accnum"> <br> <input type="text"
					class="form-control" placeholder="Amount" name="amount"><br>
				<div>
					<select class="custom-select" id="inputGroupSelect03"
						name="transactionType" required>
						<option value="DEPOSIT">DEPOSIT</option>
						<option value="WITHDRAW">WITHDRAW</option>
						<option value="BALANCE">BALANCE</option>
					</select>
				</div>
				<br>
				<div>
					<input type="submit" class="btn btn-success" value="Enter" />
				</div>
			</form>
		</div>
	</div>
	</div>
	<div text="center">
		<%
			if (i == 0) {
				out.println("Account is deactivated");
			}
		%>
	</div>
	<br>
	<br>
	<%
		Long accNum = 0l;
		double amount = 0.0;
		TransactionType transactionType = TransactionType.DEPOSIT;
		long id = 0l;
		AccountStatus status = AccountStatus.INACTIVE;
		if (flag) {
			accNum = transaction.getAccountNumber();
			amount = transaction.getAmount();
			transactionType = transaction.getType();
			id = transaction.getId();
			status = account.getAccountStatus();
		}
	%>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>AccountNumber</th>
					<th>TransactionType</th>
					<th>Amount</th>
					<th>Current Balance</th>
					<th>Account Status</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=id%></td>
					<td><%=accNum%></td>
					<td><%=transactionType%></td>
					<td><%=amount%></td>
					<td><%=balance%></td>
					<td><%=status%></td>
				</tr>
			</tbody>
		</table>
	</div>
	</form>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>