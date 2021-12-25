<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>"index"</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
	<jsp:include page="WEB-INF/cookieForm.jsp" />
    <div class="main-container">
        <div class="left-side">
       		<% out.print("Placeholder");%>
            <h3>NameOfCity</h3>
            <form action="OWservlet" method="get">
                City:<input type="text" name="city"/><br/>
                Country:<input type="text" name="country"/><br/>
                <input type="submit" value="go"/>
            </form>
        </div>
        <div class="right-side">
            <div class="weather-box">
                <p>22°C</p>
                <!-- 
                 <div class="icon-border">
           	     	<img src="https://place-puppy.com/150x150" alt="">
           	     -->
	            </div>
            </div>  
        </div>
    </div>
</body>
</html>
