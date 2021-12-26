package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetWeather;
import model.WeatherBean;
import java.util.ArrayList;
/**
 * Servlet implementation class OWservlet
 */
@WebServlet("/OWServlet")
public class OWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OWServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String city ="";
		String country ="";
		
		//getAttribute is only needed when OWServlet is reached by index.
		//Otherwise OWServlet is called by showWeather with parameters.
		if (request.getParameter("city")== null) {
			city = (String)request.getAttribute("city");
			country = (String)request.getAttribute("country");
		} else {
			city = request.getParameter("city");
			country = request.getParameter("country");
		}
		//Create WeatherBean object with either default city or user input.
		WeatherBean wBean = new WeatherBean(city, country);
		
		//Get weather data from OpenWeather API, and sets fetched data in wBean.
		GetWeather.getWeather(wBean);
		
		//Pass the wBean object to the request so that it can be accessed in view.
		request.setAttribute("wBean", wBean);
		
		//Add search cookies to the response if the user has accepted cookies.
		if (CookieHandler.cookieConsent(request).equals("accept")) {
			CookieHandler.createSearchCookie(request, response);
		}
		
		//Get a list of strings with the values of each search cookie.
		ArrayList<String> previousSearches = CookieHandler.getPreviousSearches(request);
		//Add the list of strings to the request.
		request.setAttribute("previousSearches", previousSearches);
		
		//Forward response to user.
		RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
	}
	

}

	


