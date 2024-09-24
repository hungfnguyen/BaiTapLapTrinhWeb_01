<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Profile</title>
</head>
<body>
    <h2>Update Profile</h2>
    <form method="post" action="${pageContext.request.contextPath}/uploadmulti" enctype="multipart/form-data">
        <label for="fullname">Full Name:</label><br>
        <input type="text" name="fullname" required><br><br>
        
        <label for="phone">Phone:</label><br>
        <input type="text" name="phone" required><br><br>
        
        <label for="image">Select Image to Upload:</label><br>
        <input type="file" name="image" required><br><br>
        
        <input type="submit" value="Update">
    </form>
</body>
</html>
