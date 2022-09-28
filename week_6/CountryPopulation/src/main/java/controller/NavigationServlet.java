package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.City;
import model.Country;

/**
 * Servlet implementation class NavigationServlet
 */
@WebServlet("/navigationServlet")
public class NavigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NavigationServlet() {
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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CountryHelper countryDAO = new CountryHelper();
		CityHelper cityDAO = new CityHelper();
		String act = request.getParameter("doThisToCountry");
		String path = "/viewAllCountriesServlet";
		if (act.equals("delete")) {
			try {
				// Getting the ID parameter of the country to delete
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				// Querying the database to find country using id
				Country CountryToDelete = countryDAO.searchForCountryById(tempId);
				// Delete user selected row in table
				countryDAO.deleteCountry(CountryToDelete);
				// Handle exception if no country is selected to delete
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a country");
			}
		} else if (act.equals("edit")) {
			try {
				// Getting the ID parameter of the country to edit
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				// Querying the database to find country using id
				Country itemToEdit = countryDAO.searchForCountryById(tempId);
				// User redirected to edit-country.jsp with an attribute countryToEdit that
				// contains the country
				request.setAttribute("countryToEdit", itemToEdit);
				path = "/edit-country.jsp";
				// handle exception if no country was selected to edit
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a country");
			}

			// Redirect to viewdetails-country.jsp page to view details for selected country
		} else if (act.equals("viewdetails")) {
			try {
				// Getting the ID parameter of the country to view details
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				// Querying the database to find country using id
				Country countryToViewDetails = countryDAO.searchForCountryById(tempId);
				// User redirected to viewdetails-country.jsp with an attribute
				// itemToViewDetails that contains the country
				request.setAttribute("countryToViewDetails", countryToViewDetails);
				request.setAttribute("allCities", countryToViewDetails.getListOfCities());
				path = "/viewdetails-country.jsp";
			}
			// Handle exception if no country was selected
			catch (NumberFormatException e) {
				System.out.println("Forgot to select a country");
			}

			// Redirect to add-country page to add country
		} else if (act.equals("add")) {
			path = "/add-country.jsp";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}
}
