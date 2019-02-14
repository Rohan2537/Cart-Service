<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script>
/* function check() {
	
	var x =document.getElementById("qnt").value;
	alert(x);
	for (i = 0; i < x.length; i++)
		 document.writeln("value :"+ x[i]);
	if(x == null)
		document.getElementById("qnt").value="0";
	
	document.getElementById("form").submit();
} */
/* function SomeDeleteRowFunction(){
	$('.rows').remove();
}
 */
$(document).ready(function() {
	$(".updateQuantity").change(function() {
		var row = $(this).parent().parent();
		var price = row.find('td').eq(1).html();
		var qty = $(this).val();
		var td = row.find('td').eq(4);
		var result = price * qty;
		//alert(result);
		td.html(result);
		var finalAmountTd = $('#finalAmount');	
		// To iterate all tr
		var totalPrice = 0;
		var rows = $(".rows");
		//alert(rows.length);
		rows.each(function() {
			totalPrice = totalPrice + parseFloat($(this).find('td').eq(4).html());
		}); 
		finalAmountTd.html(totalPrice);
		$('input[type="button"]').click(function(e){
			   $(this).closest('tr').remove()
			})
		/* $('#removeItem').SomeDeleteRowFunction(function() {
		$('.rows').remove();
		}) */; 
	});
	
})
</script>
</head>
<body>
	<div>
		<jsp:include page="index.jsp" />
	</div>
	<form id="form" action="removeProduct">
		<div>
			<table class="table table-bordered">

				<tr style="font-style: italic;">
					<!-- <th>CartId </th> -->
					<th>Items</th>
					<th>Price</th>
					<th>Quantity</th>
					<th>Remove from cart</th>
					<th>Product Total</th>
				</tr>
				<%-- <c:forEach var="updateCart" items="${updateCart}"> --%>
				<%-- <tr>
				<td>${updateCart.cartId}</td>
				</tr> --%>
				<c:forEach var="updateCart" items="${cart.items}">
					<tr class="rows" style="font-style: italic;">
						<td><input type="text" name="productName" readonly="readonly"
							value="${updateCart.productName}" size="25""></td>
						<td>${updateCart.price}</td>
						<td> <input type="number" name="quantity" min="1" value="${updateCart.quantity}" class="updateQuantity"/></td>
						<td> <input type="button" id="removeItem" value="Remove"/></td>
						<%-- <td><!-- <input type="text" id="qnt" name="quantity" min="1"
							style="width: 50px; height: 30px;" value="0" /> --> <a id="removeProduct" href="remove/${updateCart.productName}/quantity=${updateCart.quantity}">Remove</a> 
						</td> --%>
						<td>${updateCart.price*updateCart.quantity}</td>
					</tr>
				</c:forEach>
				<!-- <tr>
					<td><input type="button" style="margin-left: 25px"
						value="remove" onclick="check()"></td>
				</tr> -->
				<tr>
					<td style="font-style: italic; font-weight: bold">Cart Total</td>
					<td></td>
					<td></td>
					<td></td>
					<td id="finalAmount">${cart.totalPrice}</td>
					
				</tr>
				<tr>
					<td style="font-style: italic; font-weight: bold">Proceed To
						Checkout :</td>
					<td></td>
					<td></td>
					<td></td>
					<td><input value="Checkout" type="submit"></td>
				</tr>
				<%-- </c:forEach> --%>
			</table>
		</div>
	</form>
</body>
</html>