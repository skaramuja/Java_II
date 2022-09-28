package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.City;
import model.Country;

/**
 * Servlet implementation class EditCityServlet
 */
@WebServlet("/editCityServlet")
public class EditCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Create helpers for interacting with the database.
		CityHelper cityHelperDAO = new CityHelper();
		CountryHelper countryHelperDAO = new CountryHelper();
		
		// Get parameters from the user.
		String cityName = request.getParameter("cityName");
		String cityIdString = request.getParameter("cityId");
		String countryIdString = request.getParameter("countryId");
		String populationString = request.getParameter("population");
		String sizeString = request.getParameter("size");
		
		try {
			// Parse population
			int population = Integer.parseInt(populationString);
			// Parse size
			double size = Double.parseDouble(sizeString);
			// Parse city id
			int cityId = Integer.parseInt(cityIdString);
			// Parse country id
			int countryId = Integer.parseInt(countryIdString);
			
			// Get the city from the database using the city Id
			City cityToUpdate = cityHelperDAO.searchForCityById(cityId);
			
			// Update the city
			cityToUpdate.setCityPopulation(population);
			cityToUpdate.setSize(size);
			cityToUpdate.setCityName(cityName);
			
			// Update the database with new information
			cityHelperDAO.updateCity(cityToUpdate);
			
			// Get the updated country from the database
			Country country = countryHelperDAO.searchForCountryById(countryId);
			
			// Pass the country and updated list of cities in the request
			request.setAttribute("countryToViewDetails", country);
			request.setAttribute("allCities", country.getListOfCities());
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		
		// Redirect the user to servlet
		getServletContext().getRequestDispatcher("/viewdetails-country.jsp").forward(request, response);
	}

}
