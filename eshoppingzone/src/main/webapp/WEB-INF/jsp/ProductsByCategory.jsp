<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<jsp:include page="index.jsp" />
</div>
<div>
<form action="/addToCart">
<table class="table table-bordered">
		<th> ProductId  </th>
		<th> Product Name  </th>
		<th> Category  </th>
		<th> Ratings  </th>
		<th> Review  </th> 
		<!-- <th> Images  </th> -->
		<th> Price  </th>
		<th> Description  </th>
		<th> Specification  </th>
		<th> Add To Cart </th>
		<%-- <jstl:if test="${product!=null }" >
			<tr>
				<td>${product.productId}</td>
				<td>${product.productName }</td>
				<td>${product.category}</td>
				<td>${product.price}</td>
				<td>${product.description}</td>
				</tr>
		</jstl:if>	 --%>
		<jstl:forEach var="productsList" items="${product}">
			<tr>
				<td>${productsList.productId}</td>
				<td>${productsList.productName}</td>
				<td>${productsList.category}</td>
				<td>
					<table>
						<jstl:forEach var="rating" items="${productsList.rating}">
							<tr style="font-style: italic;">
								<td>${rating.key}</td>
								<td>${rating.value}</td>
							</tr>
						</jstl:forEach>	
					</table>	
				</td>
				<td>
					<table>
						<jstl:forEach var="review" items="${productsList.review}">
							<tr style="font-style: italic;">
								<td>${review.key}</td>
								<td>${review.value}</td>
							</tr>
						</jstl:forEach>	
					</table>
				</td>
				<%-- <td>${productsList.image}</td> --%>
				<td>${productsList.price}</td>
				<td>${productsList.description}</td>
				<td>
					<table>
						<jstl:forEach var="specification" items="${productsList.specification}">
							<tr style="font-style: italic;">
								<td>${specification.key}</td>
								<td>${specification.value}</td>
							</tr>
						</jstl:forEach>	
					</table>
				</td>	
				<td>
					Enter Product Id :<input name="productId" type="text">
					Quantity : <input type="number" name = "quantity" min = "1" />
					<!-- Quantity :<input name="quantity" type="number"> -->
					<input value="Add To Cart" type="submit">
						<!-- <select>
							<option name="">1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select> -->
				</td>
			</tr>
		</jstl:forEach>
</table>
</form>
</div>
</body>
</html>