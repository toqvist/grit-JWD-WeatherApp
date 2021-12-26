<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<% 
//Set default city. Set attribute is used because request dispatcher doesn't accept parameters.
request.setAttribute("city", "Helsingborg");
request.setAttribute("country", "se");

//Forward the request to servlet, in order to show information about default city.
RequestDispatcher rd = request.getRequestDispatcher("OWServlet");
rd.forward(request, response);
%>
