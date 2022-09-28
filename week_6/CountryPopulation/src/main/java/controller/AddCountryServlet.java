package controller;


import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.CountryHelper;
import model.Country;

/**
 * Servlet implementation class AddCountryServlet
 */
@WebServlet("/addCountryServlet")
public class AddCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Step 1: Collect parameters from user
		String country = request.getParameter("country");
		String city = request.getParameter("capital");
		try {
			int population = Integer.parseInt(request.getParameter("population"));
			// Step 2: Create an instance of the Country entity
			Country li = new Country(country, city, population);
			// Step 3: Use country helper to insert into the database
			CountryHelper dao = new CountryHelper();
			dao.insertCountry(li);
		
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			System.out.println("Population must be an integer"); // user validation to check that population is an integer
		}
		// Step 4: user is redirected to viewAllCountriesServlet
		getServletContext().getRequestDispatcher("/viewAllCountriesServlet").forward(request, response);
	}

}
