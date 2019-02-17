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
<title>E-ShoppingZone.com: Online Shopping Site</title>
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

.img {
	background-color: rgb(250, 241, 218);
	width: 100%;
	height: 900px;
	padding-top: 2px;
	margin-top: 0px;
}

.img1 {
	width: 250px;
	height: 400px;
	margin-top: 50px;
	margin-left: 50px;
}

.img2 {
	width: 250px;
	height: 400px;
	margin-top: -400px;
	margin-left: 420px;
}

.img3 {
	width: 250px;
	height: 400px;
	margin-top: -400px;
	margin-left: 800px;
}

.img4 {
	width: 250px;
	height: 400px;
	margin-top: -400px;
	margin-left: 1150px;
}

.img5 {
	margin-bottom: 70px;
	margin-left: 50px;
}

.img6 {
	width: 250px;
	height: 400px;
	margin-top: -400px;
	margin-left: 1150px;
}

.img7 {
	width: 250px;
	height: 400px;
	margin-top: -400px;
	margin-left: 800px;
}

.img8 {
	width: 250px;
	height: 400px;
	margin-top: -400px;
	margin-left: 420px;
}

p {
	margin-left: 40px;
}

.productName1 {
	margin-left: 40px;
}
.buyNow2 {
	margin-left: 0px;
}
.buyNow3 {
	margin-left: -30px;
}
.buyNow4 {
	margin-left:-20px;
}
.buyNow5 {
	margin-left: 0px;
}
.buyNow6 {
	margin-left: -40px;
}
.buyNow7 {
	margin-left: -40px;
}
.buyNow8 {
	margin-left: 15px;
}
</style>
</head>
<body>

	<div class="col-sm-12">
		<nav class='navbar navbar-expand navbar-light bg-light'>
			<div class="col-sm-2">
				<a class='navbar-brand'><img
					src="https://github.com/EshoppingZone/Product_images/blob/experimental/logo.JPG?raw=true"
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
								<a href="/getProductsByCategory?category=sports">Sports</a> <a
									href="/getProductsByCategory?category=kitchen">Home &
									Kitchen</a> <a href="/getProductsByCategory?category=bags">Bags
									& Luggage</a>
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
					<li><a href="/shoppingcart"> <i
							class="fa fa-shopping-cart" style="margin-left: 67px">Cart</i></a></li>
				</ul>
				<div class="authenticated" style="display: none;">
					<button onClick="logout()" class="btn btn-warning">Logout</button>
				</div>
			</div>
		</nav>
	</div>
	<div class="img">
		<div class="img1">
			<img alt="" style="border-radius: 10px;"
				src="https://github.com/EshoppingZone/Product_images/blob/experimental/106.jpg?raw=true">
			<p>Price:Rs 40800</p>
			<a class="productName1" href="searchProduct?productName=">Acer Aspire E15 Laptop</a>
			<p>
				<a class="buyNow" href="addToCart?productId=106&quantity=1">Add To Cart</a> || <a href="addToCart?productId=106&quantity=1">Buy Now</a>
			</p>
		</div>
		<div class="img2">
			<img alt="" style="border-radius: 10px;"
				src="https://github.com/EshoppingZone/Product_images/blob/experimental/138.jpg?raw=true">
			<p>Price:Rs 4995</p>
			<a class="productName2" href="searchProduct?productName=">Sujata Powermatic Juicer Mixer Grinder</a>
			<p>
				<a class="buyNow2" href="addToCart?productId=138&quantity=1">Add To Cart</a> || <a href="addToCart?productId=138&quantity=1">Buy Now</a>
			</p>
		</div>
		<div class="img3">
			<img alt="" style="border-radius: 10px;"
				src="https://github.com/EshoppingZone/Product_images/blob/experimental/111.jpeg?raw=true">
			<p>Price:Rs 244</p>
			<a class="productName3" href="searchProduct?productName=">The Power of your Subconscious Mind</a>
			<p>
				<a class="buyNow3" href="addToCart?productId=111&quantity=1">Add To Cart</a> || <a href="addToCart?productId=111&quantity=1">Buy Now</a>
			</p>
		</div>
		<div class="img4">
			<img alt="" style="border-radius: 10px;"
				src="https://github.com/EshoppingZone/Product_images/blob/experimental/122.jpg?raw=true">
			<p>Price:Rs 1299</p>
			<a class="productName4" href="searchProduct?productName=">Fur Jaden 15 Ltrs Grey Anti Theft Waterproof Backpack</a>
			<p>
				<a class="buyNow4" href="addToCart?productId=122&quantity=1">Add To Cart</a> || <a href="addToCart?productId=122&quantity=1">Buy Now</a>
			</p>
		</div>
		<div class="img5">
			<img alt="" style="border-radius: 10px;"
				src="https://github.com/EshoppingZone/Product_images/blob/experimental/141.jpg?raw=true">
			<p>Price:Rs 2004</p>
			<a class="productName5" href="searchProduct?productName=">Adidas Men's Arius 1 M Running Shoes</a>
			<p>
				<a class="buyNow5" href="addToCart?productId=141&quantity=1">Add To Cart</a> || <a href="addToCart?productId=141&quantity=1">Buy Now</a>
			</p>
		</div>
		<div class="img6">
			<img alt="" style="border-radius: 10px;"
				src="https://github.com/EshoppingZone/Product_images/blob/experimental/151.jpg?raw=true">
			<p>Price:Rs 199</p>
			<a class="productName6" href="searchProduct?productName=">Fitkit Classic Bottle Shaker 700ml</a>
			<p>
				<a class="buyNow6" href="addToCart?productId=151&quantity=1">Add To Cart</a> || <a href="addToCart?productId=151&quantity=1">Buy Now</a>
			</p>
		</div>
		<div class="img7">
			<img alt="" style="border-radius: 10px;"
				src="https://github.com/EshoppingZone/Product_images/blob/experimental/161.jpg?raw=true">
			<p>Price:Rs 599</p>
			<a class="productName7" href="searchProduct?productName=">Dennis Lingo Men's Solid Chinese Collar Blue Casual Shirt</a>
			<p>
				<a class="buyNow7" href="addToCart?productId=161&quantity=1">Add To Cart</a> || <a href="addToCart?productId=161&quantity=1">Buy Now</a>
			</p>
		</div>
		<div class="img8">
			<img alt="" style="border-radius: 10px;"
				src="https://github.com/EshoppingZone/Product_images/blob/experimental/171_1.jpg?raw=true">
			<p>Price:Rs 55990</p>
			<a class="productName8" href="searchProduct?productName=">Sony 108 cm (43 Inches) Full HD LED Smart Android TV </a>
			<p>
				<a class="buyNow8" href="addToCart?productId=171&quantity=1">Add To Cart</a> || <a href="addToCart?productId=171&quantity=1">Buy Now</a>
			</p>
		</div>
	</div>
	<footer class="container-fluid text-center">
		<p>© Online Store Copyright</p>
	</footer>
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