<%@ page isELIgnored="false" language="java"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- <style type="text/css">
table, th, td {
	padding: 5px;
	height: 80px;
	width: 1100px;
	font-size: 20px;
	text-align: center;
	font-family: inherit;
}
th, td {
	padding: 1px;
	background-color: lightgray;
}
</style> -->
<style type="text/css">
#cart {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}
#cart td, #cart th {
	border: 1px solid #ddd;
	padding: 8px;
}
#cart tr:nth-child(even) {
	background-color: #f2f2f2;
}
#cart tr:hover {
	background-color: #ddd;
}
#cart th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.9/angular.min.js"></script>
	<form action="placeOrder">
		
	<div ng-app="">
		<table id="cart">
			<tr>
				<th>Items</th>
				<th>Price</th>
				<th>Quantity</th>
				<th>Product Total</th>
			</tr>
			<jstl:forEach var="products" items="${cart.items}">
				<tr>
				<td>${products.productName}</td>
				<td><input type ="number" name = "price"  ng-model="num1" 
									ng-init = "num1=${products.price}" readonly="readonly"/></td>
				<td><input type="number" name = "quantity"  min = "1"  ng-model="num2" ng-init="num2=1" /></td>
				<td>{{ num1 * num2 }}</td>
					</tr>
				</jstl:forEach>
						</table>
<div><h3>Total Amount: <input type="number" value="{{num1*num2}}" readonly="readonly"></h3></div>
</div>


		<input type="submit" value="Place Order">
	</form>
</body>
</html>