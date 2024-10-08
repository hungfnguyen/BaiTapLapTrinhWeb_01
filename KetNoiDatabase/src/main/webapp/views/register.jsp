<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- BEGIN REGISTER FORM -->
<div class="container">
	<h2>Register</h2>
	<form action="${pageContext.request.contextPath}/register" method="post">
		<div class="form-group">
			<label for="username">Username</label>
			<input type="text" class="form-control" id="username" name="username" required>
		</div>
		<div class="form-group">
			<label for="fullname">Full Name</label>
			<input type="text" class="form-control" id="fullname" name="fullname" required>
		</div>
		<div class="form-group">
			<label for="email">Email</label>
			<input type="email" class="form-control" id="email" name="email" required>
		</div>
		<div class="form-group">
			<label for="password">Password</label>
			<input type="password" class="form-control" id="password" name="password" required>
		</div>
		<div class="form-group">
			<label for="confirm_password">Confirm Password</label>
			<input type="password" class="form-control" id="confirm_password" name="confirm_password" required>
		</div>
		<button type="submit" class="btn btn-primary">Register</button>
	</form>
</div>
<!-- END REGISTER FORM -->
