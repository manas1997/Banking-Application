
<%
	if (session != null) {
		if (session.getAttribute("userid") == null) {
			response.sendRedirect("Login.jsp");
		}
	}
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
					<div>
						<form action="Logout" method="post">

							<button type="submit" class="btn btn-danger" value="logout">Logout</button>
						</form>
					</div>
				</div>
			</li>
		</ul>
	</nav>
	<br>
	<br>
	<br>
	<br>
	<h2 align="center">Add Account To User</h2>
	<br>
	<br>
	<div class="row">
		<div class="col-lg-4"></div>
		<div class="col-lg-4">
			<form method="post" action="AddAccount">
				<input type="text" class="form-control" placeholder="User ID"
					name="userNumber"><br> <input type="submit"
					class="btn btn-success" value="Search" />

			</form>
		</div>
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