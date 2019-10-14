
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
	User user = null;
	boolean flag = false;
	if (request.getMethod().equals("GET") && request.getParameter("result") != null) {
		user = (User) session.getAttribute("userdata");
		flag = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<!-- Bootstrap CSS -->
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
			<li class="nav-item">
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
	<h2 align="center">Display User Details</h2>
	<br>
	<br>
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-4"></div>
			<div class="col-lg-4">
				<form method="post" action="DisplayUserDetails">
					<input type="text" class="form-control" placeholder="User ID"
						name="userId" required><br> <input type="submit"
						class="btn btn-success" value="Search" />
				</form>
			</div>
		</div>
	</div>
	<br>
	<br>
	<%
		Long accNum = 0l;
		String firstName = "";
		String status = "";
		String city = "";
		String lastName = "";
		String gender = "";
		long id = 0l;
		if (flag) {
			accNum = user.getAccount().getAccountNumber();
			firstName = user.getFirstName();
			gender = user.getGender();
			lastName = user.getLastName();
			city = user.getCity();
			status = user.getUserStatus().toString();
			id = user.getId();
		}
	%>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Gender</th>
					<th>City</th>
					<th>Account Number</th>
					<th>Status</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=id%></td>
					<td><%=firstName%></td>
					<td><%=lastName%></td>
					<td><%=city%></td>
					<td><%=gender%></td>
					<td><form action="DisplayAccount" method="get">
							<input type="hidden" name="accNum" value="<%=accNum%>">
							<button type="submit" class="btn btn-outline-primary btn-block"><%=accNum%></button>
						</form></td>
					<td><%=status%></td>
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