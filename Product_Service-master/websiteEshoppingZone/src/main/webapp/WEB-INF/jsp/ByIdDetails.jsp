<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
		<tr> ProductId </tr>
		<tr> Product Name </tr>
		<tr> Category </tr>
		<tr> Ratings </tr>
		<tr> Review </tr> 
		<tr> Images </tr>
		<tr> Price </tr>
		<tr> Description </tr>
		<tr> Specification </tr>
		
		<jstl:if test="${product!=null }" >
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName }</td>
				<td>${product.category}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
				</tr>
		</jstl:if>	
		</table>
</body>
</html>