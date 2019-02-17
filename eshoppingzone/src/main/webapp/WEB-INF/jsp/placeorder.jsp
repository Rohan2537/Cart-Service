<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
	<style type="text/css">
		.form-inline{
			margin-left:400px;
			margin-top: 30px;
		}
		.background-div{
					width: 400px;
					height: 500px;
					background-color: #faf1da;
					margin-left: 500px;
					margin-top:100px;
					border-color: black;
					border-radius: 10px;
		}
	</style>
</head>
<body class="body">
 <div class="background-div"></div>
	<div class="container">
		<h2 align="center" style="font-style: oblique; margin-top: -490px; margin-left: -60px;">Address</h2>

		<form class="form-inline" action="payment">
		<div class="form-group" align="center">
				Customer Id:&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only""></label> <input
					type="text" class="form-control" placeholder="Enter Customer Id" name="customerId" readonly="readonly" value="${address.customerId}">
			</div>
			<br> <br>
			<div class="form-group" align="center">
				Full Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only""></label> <input
					type="text" class="form-control" placeholder="Enter Full Name" name="fullName" value="${address.fullName}" readonly="readonly">
			</div>
			<br> <br>
			<div class="form-group">
				Mobile Number:<label class="sr-only" ></label> <input
					type="text" class="form-control" placeholder="Enter Mobile Number" name="mobileNumber" value="${address.mobileNumber}" readonly="readonly">
			</div>
			<br> <br>
			<div class="form-group">
				Flat No:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only"></label> <input
					type="text" class="form-control" placeholder="Enter Flat No." name="flatNo" value="${address.flatNumber}" readonly="readonly">
			</div>
			<br> <br>
			<div class="form-group">
				City:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only"></label> <input
					type="text" class="form-control" placeholder="Enter City" name="city" value="${address.city}" readonly="readonly">
			</div>
			<br> <br>
			<div class="form-group">
				Pin Code:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only"></label> <input
					type="text" class="form-control" placeholder="Enter Pincode" name="pincode" value="${address.pincode}" readonly="readonly">
			</div>
			<br> <br>
			<div class="form-group">
				State:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only"></label> <input
					type="text" class="form-control" placeholder="Enter state" name="state" value="${address.state}" readonly="readonly">
			</div>
			<br> <br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" id="button" class="btn btn-default">Submit</button>
		</form>
	</div>

</body>
</html>
