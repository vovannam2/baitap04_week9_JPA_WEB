<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="<c:url value="/admin/category/insert"/>" method="post"
		enctype="multipart/form-data">
		<label for="fname">Category name:</label><br> <input type="text"
			id="categoryname" name="categoryname"><br> <label
			for="lname">Link images:</label><br> <input type="text"
			id="images" name="images"><br> <label for="lname">Upload
			images:</label><br> <input type="file" id="images1" name="images1"><br>
		<label for="html">Status</label><br> <input type="radio"
			id="ston" name="status" value="1"> <label for="css">Hoạt
			động</label><br> <input type="radio" id="stoff" name="status" value="0">
		<label for="javascript">Khóa</label> <br>
		<br> <input type="submit" value="Insert">
	</form>
</body>
</html>