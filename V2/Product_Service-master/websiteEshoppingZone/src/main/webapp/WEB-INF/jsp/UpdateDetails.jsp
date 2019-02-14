<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="updatedb">
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
				<td><input name="productId" value=${product.productId} readonly="readonly" /></td>
				<td><input name="productName" value=${product.productName} readonly= "readonly" /></td>
				<td><input name= "category" value=${product.category} readonly="readonly" /></td>
				<td><input name="price" value=${product.price} /></td>
				<td><input name="description" value=${product.description} /></td>
				</tr>
		</jstl:if>	
		
	</table>
	<input type="submit" value="Update">
	<input type="reset" value="Reset">
	</form>
</body>
</html>