<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
	<table>
		<tr>
			<th>CartId </th>
			<th> Items</th>
			<th>Total </th>
		</tr>
		<%-- <c:forEach var="updateCart" items="${updateCart}"> --%>
			<tr>
				<td>${updateCart.cartId}</td>
				<td>${updateCart.items}</td>
				<td>${updateCart.totalPrice}</td>
			</tr>
		<%-- </c:forEach> --%>
	</table>
	</div>
</body>
</html>