package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.City;
import model.Country;

/**
 * Servlet implementation class AddCityServlet
 */
@WebServlet("/addCityServlet")
public class AddCityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCityServlet() {
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
		CountryHelper countryDAO = new CountryHelper();
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		// Get the country out of the database
		Country country = countryDAO.searchForCountryById(tempId);
		
		// Collect parameters from user
		String name = request.getParameter("cityName");
		String populationString = request.getParameter("population");
		String sizeString = request.getParameter("size");
				
		try {
			int population = Integer.parseInt(populationString);
			double size = Double.parseDouble(sizeString);
			
			// Create an instance of the City entity
			City city = new City(name, population, size);
			
			// Use city helper to insert into the database
			CityHelper dao = new CityHelper();
			dao.insertCity(city);
			
			// Get the current list of cities for the country and update it
			List<City> listOfCities = country.getListOfCities();
			listOfCities.add(city);
			country.setListOfCities(listOfCities);
			
			// Update the country in the database (also updates relationship table)
			countryDAO.updateCountry(country);

			// Set the proper attributes on the request to display the country
			request.setAttribute("countryToViewDetails", country);
			request.setAttribute("allCities", listOfCities);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			System.out.println("Population and size must be an integer");
		}
		
		// Redirect the user to view the country details.
		getServletContext().getRequestDispatcher("/viewdetails-country.jsp").forward(request, response);
	}

}
