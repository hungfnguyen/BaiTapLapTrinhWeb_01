<%-- <%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
	<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="fn" uri="jakarta.tags.functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="form-container">
		<h1>Register</h1>
		<form action="/KetNoiDatabase/register" method="post">

			<c:if test="${alert !=null}">
				<h3 class="alert alertdanger">${alert}</h3>
			</c:if>
			<table>


				<tr>
					<td>Username</td>
					<td><input type="text" name="username" required /></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="text" name="email" required /></td>
				</tr>
				<tr>
					<td>Fullname</td>
					<td><input type="text" name="fullname" /></td>
				</tr>
				<tr>
					<td>Phone</td>
					<td><input type="text" name="phone" required /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" />
		</form>
	</div>
</body>
</html>