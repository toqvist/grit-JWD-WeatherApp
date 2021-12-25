package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHandler {

	
	//Creates a cookie "consent" with the value of parameter "consent", should only be called by CookieServlet that has "consent" parameter.
	public static void createConsentCookie(HttpServletRequest request, HttpServletResponse response) {

		Cookie consentCookie = new Cookie("cookies", request.getParameter("consent"));
		// Set expiration time for cookie
		consentCookie.setMaxAge(60 * 2);
		// Add the cookie to the response
		response.addCookie(consentCookie);
	}

	
	public static void createSearchCookie(HttpServletRequest request, HttpServletResponse response) {

		// Technically these variables could be parameters instead, but I think this is
		// more readable.
		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");

		Cookie searchCookie = new Cookie("search", countryStr + cityStr);

		// Set expiration time for cookie
		searchCookie.setMaxAge(60 * 2);
		// Add the cookie to the response
		response.addCookie(searchCookie);

	}

	public static boolean cookieConsent(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		
		if (cookies != null) {
			for (int i=0;i<cookies.length;i++) {
				System.out.println(cookies[i]);
				if (cookies[i].getName().equals("cookies")) {
					if (cookies[i].getValue().equals("accept")) {
						System.out.println("cookieConsent returned true");
						return true;
					}	
				}
			}
			return false;
			
		} else {
			return false;
		}
	}
	

	// Cookie ck[] = request.getCookies();
	// System.out.println("Cookie: " + ck[1].getValue()); //accept or deny

	// if request has attribute "accept", set consent cookie
	//
	// CookieHandler.createConsentCookie(request, response);

	// if consentCookie is not null or deny, create a search cookie
	// if (cookie value == accept)
	// CookieHandler.createSearchCookie(cityStr, countryStr, request, response);
	
}
