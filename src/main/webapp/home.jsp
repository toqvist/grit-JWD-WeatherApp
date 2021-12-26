<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="controller.CookieHandler"%>
<%@page import="model.WeatherBean"%>
<%
WeatherBean wBean = (WeatherBean) request.getAttribute("wBean");
%>
<!DOCTYPE html>
<html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>"WeatherApp: <%=wBean.getCity()%>"
</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<%
	if (CookieHandler.cookieConsent(request).equals("none")) {
	%>
	<jsp:include page="WEB-INF/cookieForm.jsp" />
	<%
	}
	%>
	
	<jsp:include page="WEB-INF/showWeather.jsp" />
	<jsp:include page="WEB-INF/footer.jsp" />
</body>
</html>