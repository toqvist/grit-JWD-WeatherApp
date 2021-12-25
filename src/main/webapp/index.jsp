<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
//Set default city.
request.setAttribute("city", "Helsingborg");
request.setAttribute("country", "se");

//Send request to servlet, in order to show information about default city.
RequestDispatcher rd = request.getRequestDispatcher("OWServlet");
rd.forward(request, response);
%>
