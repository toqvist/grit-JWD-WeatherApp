package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* CookieHandler is a helper class mainly used by the OWServlet. Is responsible for:
 * - Cookie creation
 * - Reading the city and country values of cookies
 * - Checking if consent has been given, or if the cookieForm has been ignored (or the consnetCookie expired).
 */

public class CookieHandler {

	
	//Creates a cookie "consent" with the value of parameter "consent", should only be called by CookieServlet that has "consent" parameter.
	public static void createConsentCookie(HttpServletRequest request, HttpServletResponse response) {

		Cookie consentCookie = new Cookie("cookies", request.getParameter("consent"));
		// Set expiration time for cookie
		consentCookie.setMaxAge(60 * 5);
		// Add the cookie to the response
		response.addCookie(consentCookie);
	}

	
	public static void createSearchCookie(HttpServletRequest request, HttpServletResponse response) {

		// Technically these variables could be parameters instead, but I think this is
		// more readable.
		String city = request.getParameter("city");
		String country = request.getParameter("country");
		
		if (city != null && country != null) {
			String cookieStr = "search%" + city;
			Cookie searchCookie = new Cookie(cookieStr, country + "%" + city + "%");
	
			// Set expiration time for cookie
			searchCookie.setMaxAge(60 * 2);
			// Add the cookie to the response
			response.addCookie(searchCookie);
		}

	}

	public static String cookieConsent(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		
		if (cookies.length > 1){
			for (int i=0;i<cookies.length;i++) {
				System.out.println(cookies[i]);
				if (cookies[i].getName().equals("cookies")) {
					if (cookies[i].getValue().equals("accept")) {
						return "accept";
					} else {
						return "deny";
					}
					
				}
			}
			return "none";
			
		} else {
			return "none";
		}
	}
	
	/*
	public static boolean answeredConsentForm(HttpServletRequest request) {
		Cookie cookies[] = request.getCookies();
		
	}
	*/
	
	public static ArrayList<String> getPreviousSearches (HttpServletRequest request) {
		
		Cookie cookies[] = request.getCookies();
		
		ArrayList<String> searches= new ArrayList<>();
		
		//Go through in reverse order so that latest searches will be at the top.
		for (int i=(cookies.length)-1;i>=0;i--) {
			//System.out.println(i);
			
			if(cookies[i].getName().contains("search%")) {
				
				searches.add(cookies[i].getValue());
			}			
		
		}
		return searches;
	}

}
