package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.City;
import model.Country;

/**
 * Servlet implementation class CityNavigationServlet
 */
@WebServlet("/cityNavigationServlet")
public class CityNavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityNavigationServlet() {
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
		CityHelper cityHelperDAO = new CityHelper();
		CountryHelper countryHelperDAO = new CountryHelper();
		String act = request.getParameter("doThisToCity");
		String path = "/navigationServlet";
		if (act.equals("delete")) {
			try {
				// Getting the ID parameter of the city to delete
				Integer tempId = Integer.parseInt(request.getParameter("cityId"));
				
				// Getting the ID parameter of the city to delete
				Integer countryId = Integer.parseInt(request.getParameter("countryId"));
				
				// Get the country out of the database
				Country country = countryHelperDAO.searchForCountryById(countryId);
				
				// Querying the database to find city using id
				City cityToDelete = cityHelperDAO.searchForCityById(tempId);
				
				// Get the current list of cities for the country and update it
				List<City> listOfCities = country.getListOfCities();
				ArrayList<City> newCities = new ArrayList<City>();
				
				// Removes city from listOfCities
				for (int i = 0; i < listOfCities.size(); i++) {
					City tempCity = listOfCities.get(i);
					if (tempCity.getId() != tempId) {
						newCities.add(tempCity);
					}
				}
				country.setListOfCities(newCities);
				
				// Update the country in the database
				countryHelperDAO.updateCountry(country);
				
				// Delete user selected row in table
				cityHelperDAO.deleteCity(cityToDelete);
				
				// Set the proper attributes on the request to display the country
				request.setAttribute("countryToViewDetails", country);
				request.setAttribute("allCities", newCities);
				
				// Redirect the user to view the country details.
				path = "/viewdetails-country.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a city");
			}
		} else if (act.equals("edit")) {
			// Getting the ID parameter of the city to delete
			Integer countryId = Integer.parseInt(request.getParameter("countryId"));
			Country selectedCountry = countryHelperDAO.searchForCountryById(countryId);
			request.setAttribute("selectedCountry", selectedCountry);
			
			Integer cityId = Integer.parseInt(request.getParameter("cityId"));
			City selectedCity = cityHelperDAO.searchForCityById(cityId);
			request.setAttribute("cityToEdit", selectedCity);
			
			path = "/edit-city.jsp";
			
		} else if (act.equals("add")) {
			// Getting the ID parameter of the city to delete
			Integer tempId = Integer.parseInt(request.getParameter("countryId"));
			// Querying the database to find city using id
			Country country = countryHelperDAO.searchForCountryById(tempId);
			request.setAttribute("country", country);
			path = "/add-city.jsp";
		}
		
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
