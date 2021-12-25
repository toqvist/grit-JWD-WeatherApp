<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
//Set default city.
request.setAttribute("city", "Helsingborg");
request.setAttribute("country", "se");

RequestDispatcher rd = request.getRequestDispatcher("OWServlet");
rd.forward(request, response);
%>
