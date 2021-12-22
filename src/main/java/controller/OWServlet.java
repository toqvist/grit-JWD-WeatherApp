package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.GetWeather;
import model.WeatherBean;

/**
 * Servlet implementation class OWservlet
 */
@WebServlet("/OWservlet")
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

		String cityStr = request.getParameter("city");
		String countryStr = request.getParameter("country");

		WeatherBean wBean = new WeatherBean(cityStr, countryStr);

		GetWeather.getWeather(wBean);

		request.setAttribute("wBean", wBean);
		
	    Cookie cookie = new Cookie("city-search", "$cty:" + cityStr + "$ctry:" + countryStr);
	    
	    //Set expiration time, 
	    cookie.setMaxAge(60 * 2);
	    //Add the cookie to the response
	    response.addCookie(cookie);

		RequestDispatcher rd = request.getRequestDispatcher("showWeather.jsp");
		rd.forward(request, response);
	}
}

	


