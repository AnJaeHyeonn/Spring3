<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<c:import url="../temp/boot_head.jsp"></c:import>
</head>
<body>
	<c:import url="../temp/boot_nav.jsp"></c:import>
	<div class="container-fluid">
		<div class="col-md-8 mx-auto my-0">
			<table class="table table-hover">
				<tr>
					<th>Number</th>
					<th>Name</th>
					<th>Rate</th>
				</tr>
				<c:forEach items="${list}" var="dto">
					<tr>
						<td>${dto.bookNumber}</td>
						<td>${dto.bookName}</td>
						<td>${dto.bookRate}</td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</body>

</html>