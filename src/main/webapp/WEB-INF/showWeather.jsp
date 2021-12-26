<%@page import="java.util.ArrayList"%>
<%@page import="model.WeatherBean"%>
<%
WeatherBean wBean = (WeatherBean) request.getAttribute("wBean");
ArrayList<String> previousSearches = (ArrayList<String>) request.getAttribute("previousSearches");
%>
<div class="main-container">

	<div class="weather-entry-box">

		<div class="left-side">

			<h3><%=wBean.getCity()%>:
				<%=wBean.getDescription()%></h3>

			<form action="OWServlet" method="get">
				City:<input type="text" name="city" /><br /> Country:<input
					type="text" name="country" /><br /> <input type="submit"
					value="go" />
			</form>
		</div>
		<div class="right-side">
			<div class="weather-box">
				<p><%=wBean.getTempC()%>°C
				</p>
				<div class="icon-border">
					<div class="icon"><%=wBean.getIcon()%></div>
				</div>

			</div>
		</div>

	</div>

	<div class="detailed-info-box">
		<div class="left-side">
			<ul class="previous-searches">
				<%
				for (int i = 0; i < previousSearches.size(); i++) {
					//String[0] = country code, String[1]= city name
					String[] search = previousSearches.get(i).split("%");
					out.println("<li><a href=\"OWServlet?city=" + search[1] + "&country=" + search[0] + "\">" + search[1] + ", "
					+ search[0] + "</a></li>");
				}
				%>
			</ul>
		</div>
		<div class="right-side">
			<% out.print("<p>Clouds: " + wBean.getClouds() + "</p>"); %>
			<% out.print("<p>Rain: " + wBean.getPrecipitation() + "</p>");
			%>

		</div>
	</div>
</div>
