package model;

import javax.servlet.http.Cookie;

public class CookieCreator {
	Cookie ck[] = request.getCookies();
	out.print("Hello " + ck[0].getValue());
}


public void createCookie {
	// TODO Auto-generated method stub
	response.getWriter().append("Served at: ").append(request.getContextPath());

	try {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("cookieName");
		out.print("Welcome " + n);

		Cookie ck = new Cookie("cname", n);// creating cookie object
		
		
		ck.setMaxAge(10); // set how long the cookie lasts
		response.addCookie(ck);// adding cookie in the response

		// creating submit button
		out.print("<form action='eatCookie'>");
		out.print("<input type='submit' value='go'>");
		out.print("</form>");

		out.close();

	} catch (Exception e) {
		System.out.println(e);
	}
}