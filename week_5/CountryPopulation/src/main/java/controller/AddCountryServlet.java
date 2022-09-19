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
		String country = request.getParameter("country");
		String city = request.getParameter("capital");
		try {
			int population = Integer.parseInt(request.getParameter("population"));
			Country li = new Country(country, city, population);
			CountryHelper dao = new CountryHelper();
			dao.insertCountry(li);

		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			System.out.println("Population must be an integer");
		}

		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
