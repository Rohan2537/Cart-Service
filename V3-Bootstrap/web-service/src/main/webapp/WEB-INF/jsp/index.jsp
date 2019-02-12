<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
	<table class="table table-bordered">
		 
		<tr style="font-style: italic;">
			<!-- <th>CartId </th> -->
			<th> Items</th>
			<th> Price </th>
			<th> Quantity </th>
			<th> Product Total </th>
		</tr>
		<%-- <c:forEach var="updateCart" items="${updateCart}"> --%>
			<%-- <tr>
				<td>${updateCart.cartId}</td>
				</tr> --%>
				<c:forEach var="cartItem" items="${updateCart.items}">
					<tr style="font-style: italic;">
						<td>${cartItem.productName}</td>
						<td>${cartItem.price}</td>
						<td>${cartItem.quantity}</td>
						<td>${cartItem.price*cartItem.quantity}</td>
					</tr>
				</c:forEach>	
				<tr>
				<td style="font-style: italic;font-weight:bold">Cart Total</td>
				<td></td>
				<td></td>
				<td>${updateCart.totalPrice}</td>
				</tr>
		<%-- </c:forEach> --%>
	</table>
	</div>
</body>
</html>