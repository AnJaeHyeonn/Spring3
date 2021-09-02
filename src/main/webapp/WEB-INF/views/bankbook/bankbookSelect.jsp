<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>

</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>

	<div class="container-fluid">

		<h3>BookNumber : ${dtov.bookNumber}</h3>
		<h3>BookName : ${dtov.bookName}</h3>
		<h3>BookRate : ${dtov.bookRate}</h3>
		<h3>BookSale : ${dtov.bookSale}</h3>

		<a href="./bankbookDelete?bookNumber=${dtov.bookNumber}">Delete</a>
	</div>


</body>
</html>