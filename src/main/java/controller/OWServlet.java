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
		// TODO Auto-generated method stub
		String city ="";
		String country ="";
		if (request.getParameter("city")== null) {
			System.out.println("city param is null");
			city = (String)request.getAttribute("city");
			country = (String)request.getAttribute("country");
		} else {
			System.out.println("city param is not null");
			city = request.getParameter("city");
			country = request.getParameter("country");
		}
		
		WeatherBean wBean = new WeatherBean(city, country);

		GetWeather.getWeather(wBean);

		request.setAttribute("wBean", wBean);
		
		
		//----Call cookie handler and add cookies to the response
		//System.out.println(CookieHandler.cookieConsent(request));
		if (CookieHandler.cookieConsent(request)) {
			CookieHandler.createSearchCookie(request, response);
		} 
		RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
	}
	

}

	


