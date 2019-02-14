<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="webjars/jquery/jquery.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.nav-link {
	font-size: large;
	margin-left: 45px;
}

.search-container input [type=text] {
	font-size: 17px;
	border: 1px solid grey;
	background: #F1F1F1
}

.search-container button {
	width: 10%;
	padding: 6px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	background: #2196F3;
	color: white;
	border-left: none;
	cursor: pointer;
	font-size: 12px;
	line-height: normal;
	padding: 11px;
}

.search-container button:hover {
	background: #0b7dda;
}

.search-container ::after {
	content: "";
	clear: both;
	display: table;
}

#search {
	float: left;
	width: 90%;
	padding: 6px;
}

.dropbtn {
	padding: 0.5rem 1rem;
	margin-left: 3rem;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f1f1f1;
	min-width: 160px;
	box-shadow: 0px8px16px0pxrgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #086cbd;
}
</style>
</head>
<body>

	<div class="col-sm-12">
		<nav class='navbar navbar-expand navbar-light bg-light'>
			<div class="col-sm-2">
				<a class='navbar-brand'><img src="assets/images/logo.JPG"
					alt="EShoppingZone"></a>
			</div>
			<div class="col-sm-3">
				<ul class='nav nav-pills'>
					<li><a href="/home">Home</a></li>
					<li>
						<div class="dropdown">
							<button class="btn btn-primary dropbtn">Categories</button>
							<div class="dropdown-content">
								<a href="/getProductsByCategory?category=electronics">Electronics</a> 
								<a href="/getProductsByCategory?category=books">Books&Stationary</a>
								<a href="/getProductsByCategory?category=clothing">Clothing</a> 
								<a href="/getProductsByCategory?category=footwear">FootWear</a>
								<a href="/getProductsByCategory?category=sports">Sports</a> 
								<a href="/getProductsByCategory?category=kitchen">Home & Kitchen</a> 
								<a href="/getProductsByCategory?category=bags">Bags & Luggage</a>
							</div>
						</div>
					</li>

				</ul>
			</div>
			<div class="col-sm-4 search-container">
				<form action="/searchproduct">
					<input type="text" placeholder="Search.." name="search" id="search">
					<button type="submit">
						<i class="fa fa-search"></i>
					</button>
				</form>
			</div>
			<div class="col-sm-4">

				<ul class='nav nav-pills'>
				<div class="unauthenticated">
					<li><a href="/signin" style="margin-left: 32px" class="">Sign
							In</a></li>
				</div>
					<li><a href="/shoppingcart"> <i class="fa fa-shopping-cart"
							style="margin-left: 67px">Cart</i></a></li>
				</ul>
				<div class="authenticated" style="display:none;">
				<button onClick="logout()" class="btn btn-warning">Logout</button>
				</div>
			</div>
		</nav>
	</div>
	<script>
		
		$.get("/user", function(data) {
			$("#user").html(data.userAuthentication.details.name);
			$(".unauthenticated").hide()
			$(".authenticated").show()
		});
		var logout = function() {
			$.post("/logout", function() {
				window.open('https://github.com/logout');
				$("#user").html('');
				$(".unauthenticated").show();
				$(".authenticated").hide();
			});
			return true;
		} 

	</script>
</body>
</html>