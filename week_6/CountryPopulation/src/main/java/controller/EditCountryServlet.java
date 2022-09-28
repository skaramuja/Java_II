package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Country;

/**
 * Servlet implementation class EditCountryServlet
 */
@WebServlet("/editCountryServlet")
public class EditCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditCountryServlet() {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// All three modifiable parameters are passed in along with the id 
		CountryHelper dao = new CountryHelper();
		String country = request.getParameter("country");
		String capital = request.getParameter("capital");
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		// Querying the database to find country using id
		Country countryToUpdate = dao.searchForCountryById(tempId);
		try {
			int population = Integer.parseInt(request.getParameter("population"));
			countryToUpdate.setPopulation(population);
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}
		// Update country enity with user input
		countryToUpdate.setCountry(country);
		countryToUpdate.setCapital(capital);
		// Update the database with new information
		dao.updateCountry(countryToUpdate);
		// Redirect the user to the viewAllCountries servlet 
		getServletContext().getRequestDispatcher("/viewAllCountriesServlet").forward(request, response);
	}

}
