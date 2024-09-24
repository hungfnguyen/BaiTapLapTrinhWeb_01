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
<title>Forgot Password</title>
</head>
<body>
	<form action="/KetNoiDatabase/forgot-password" method="post">
        <div>
            <label for="email"><b>Email</b></label>
            <input type="email" placeholder="Enter your email" name="email" required>
            <button type="submit">Submit</button>
        </div>
    </form>

    <c:if test="${oldPassword != null}">
        <p>Password của bạn là: ${oldPassword}</p>
    </c:if>

    <c:if test="${alert != null}">
        <h3 class="alert alert-danger">${alert}</h3>
    </c:if>
    
    <!-- Nút quay về trang login -->
    <div>
        <a href="/KetNoiDatabase/login" class="btn">Quay về trang đăng nhập</a>
    </div>
</body>
</html>