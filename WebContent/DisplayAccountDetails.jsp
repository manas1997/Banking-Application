<%@page import="main.java.com.epam.enums.AccountType"%>
<%@page import="main.java.com.epam.enums.AccountStatus"%>
<%
	if (session != null) {
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("Login.jsp");
		}
	}
%>
<%@page import="main.java.com.epam.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="main.java.com.epam.model.Account"%>

<%
	Account account = null;
	boolean flag = false;
	if (request.getMethod().equals("GET") && request.getParameter("result") != null) {
		account = (Account) session.getAttribute("account");
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
	<h2 align="center">Display Account Details</h2>
	<br>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<form method="get" action="DisplayAccount">
					<input type="text" class="form-control"
						placeholder="Account Number" name="accNum" required><br>
					<input type="submit" class="btn btn-success" value="Search" />
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<%
		Long accountNum = 1l;
		AccountStatus status = AccountStatus.ACTIVE;
		AccountType type = AccountType.CURRENT;
		double balance = 0.0;
		if (flag) {
			accountNum = account.getAccountNumber();
			status = account.getAccountStatus();
			type = account.getAccountType();
			balance = account.getBalance();
		}
	%>

	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Account Number</th>
					<th>Account Type</th>
					<th>Balance</th>
					<th>Status</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=accountNum%></td>
					<td><%=type%></td>
					<td><%=balance%></td>
					<td
						class="text-<%=status == (AccountStatus.ACTIVE) ? "success" : "danger"%>"><b><%=status%></td>
					<%
						if (status == AccountStatus.ACTIVE) {
					%>
					<td><a href="ActiveToggle?accNum=<%=accountNum%>&opr=1"><button
								type="button" class="btn btn-outline-primary btn-block"
								value="redirect">Deactivate</button></a></td>
					<%
						} else {
					%>
					<td><a href="ActiveToggle?accNum=<%=accountNum%>&opr=2"><button
								type="submit" class="btn btn-outline-primary btn-block"
								value="redirect">Activate</button></a></td>
					<%
						}
					%>
				</tr>
			</tbody>
		</table>
	</div>
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