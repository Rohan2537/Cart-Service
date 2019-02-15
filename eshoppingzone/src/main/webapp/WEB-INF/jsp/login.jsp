<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body {
    font-family: Arial, Helvetica, sans-serif;
  }
  

* {
    box-sizing: border-box;
  }
  
  /* style the container */
  .container {
    position: relative;
    border-radius: 5px;
    background-color: #f2f2f2;
    padding: 0px 0 0px 0;
  } 
  
  /* style inputs and link buttons */
  input,
  .btn {
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 4px;
    margin: 14px 0;
    opacity: 0.85;
    display: inline-block;
    font-size: 17px;
    line-height: 25px;
    text-decoration: none; /* remove underline from anchors */
  }
  
  input:hover,
  .btn:hover {
    opacity: 1;
  }
  
  /* add appropriate colors to fb, twitter and google buttons */
  .github {
   background-color: rgb(12, 12, 12);
    color: white;
    line-height: normal;
  }
  
  .linkedin {
    background-color: rgb(10, 102, 240);
    color: white;
    line-height: normal;
  }
  
  
  
  /* style the submit button */
  input[type=submit] {
    background-color: rgb(10, 102, 240);
    color: white;
    cursor: pointer;
  }
  
  input[type=submit]:hover {
    background-color: #45a049;
  }
  
  /* Two-column layout */
  .col {
    float: left;
    width: 50%;
    margin: auto;
    padding: 0 50px;
  }
  
  /* Clear floats after the columns */
  .row:after {
    content: "";
    display: table;
    clear: both;
  }
  
  /* vertical line */
  .vl {
    position: absolute;
    left: 50%;
    transform: translate(-50%);
    border: 2px solid #ddd;
    height: 175px;
  }
  
  /* text inside the vertical line */
  .vl-innertext {
    position: absolute;
    top: 50%;
    transform: translate(-50%, -50%);
    background-color: #f1f1f1;
    border: 1px solid #ccc;
    border-radius: 50%;
    padding: 8px 10px;
  }
  
  /* hide some text on medium and large screens */
  .hide-md-lg {
    display: none;
  }
  
  /* bottom container */
  .bottom-container {
    text-align: center;
    background-color: #666;
    border-radius: 0px 0px 3px 3px;
    margin-top: 50px;
    height: 80px;
  }
  </style>
  
</head>
<body>

    <div class="container">
        <form action="/action_page.php">
          <div class="row">
          <h2 style="text-align:center">Login with Social Media or Manually</h2>
            <div class="vl">
              <span class="vl-innertext">or</span>
            </div>
      
            <div class="col">
              <a href="/login" class="github btn">
                <i class="fa fa-github"></i> Login with GitHub
               </a>
              <a href="/linkedin" class="linkedin btn">
                <i class="fa fa-linkedin"></i> Login with LinkedIn
              </a>
              
            </div>
      
            <div class="col">
              <div class="hide-md-lg">
                <p>Or sign in manually:</p>
              </div>
      
              <input type="text" name="username" placeholder="Email Id/Mobile Number" required>
              <input type="password" name="password" placeholder="Password" required>
              <input type="submit" value="Login">
            </div>
            
          </div>
        </form>
   
      
      <div class="bottom-container">
        <div class="row">
          <div class="col">
            <a class='nav-link btn' href="/signup" style="color:white">Sign up</a>
          </div>
          <div class="col">
            <a class='nav-link btn' href="/forgotpassword" style="color:white">Forgot password?</a>
          </div>
        </div>
      </div>
    </div>
</body>
</html>
