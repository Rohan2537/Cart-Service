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
		<h2 align="center" style="font-style: oblique; margin-top: -470px; margin-left: -60px;">Address Details</h2>

		<form class="form-inline" action="address">
			<div class="form-group" align="center">
				Full Name:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only""></label> <input
					type="text" class="form-control"
					placeholder="Enter Full Name" name="fullName">
			</div>
			<br> <br>
			<div class="form-group">
				Mobile Number:<label class="sr-only" ></label> <input
					type="text" class="form-control"
					placeholder="Enter Mobile Number" name="mobileNumber">
			</div>
			<br> <br>
			<div class="form-group">
				Flat No:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only" for="email"></label> <input
					type="text" class="form-control" id="email"
					placeholder="Enter Flat No." name="flatNo">
			</div>
			<br> <br>
			<div class="form-group">
				City:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only" for="email"></label> <input
					type="text" class="form-control" id="email"
					placeholder="Enter City" name="city">
			</div>
			<br> <br>
			<div class="form-group">
				Pin Code:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only" for="email"></label> <input
					type="text" class="form-control" id="email"
					placeholder="Enter Pincode" name="pincode">
			</div>
			<br> <br>
			<div class="form-group">
				State:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<label class="sr-only" for="email"></label> <input
					type="text" class="form-control" id="email"
					placeholder="Enter state" name="state">
			</div>
			<br> <br>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<button type="submit" id="button" class="btn btn-default">Submit</button>
		</form>
	</div>

</body>
</html>
