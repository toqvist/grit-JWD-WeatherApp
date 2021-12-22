<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.WeatherBean"%>


<%
WeatherBean wBean = (WeatherBean) request.getAttribute("wBean");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>"WeatherApp: <%=wBean.getCityStr()%>"</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div class="main-container">
        <div class="left-side">
       		<% out.print("<p>Clouds: " + wBean.getCloudsStr() + "</p>");%>
            <h3><%=wBean.getCityStr()%></h3>
            <form action="OWservlet" method="get">
                City:<input type="text" name="city"/><br/>
                Country:<input type="text" name="country"/><br/>
                <input type="submit" value="go"/>
            </form>
        </div>
        <div class="right-side">
            <div class="weather-box">
                <p><%=wBean.getTempC() %>°C</p>
                <div class="icon-border">
             		<div class="icon"><%= wBean.getIcon() %></div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
