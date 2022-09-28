package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewAllICountriesServlet
 */
@WebServlet("/viewAllCountriesServlet")
public class ViewAllCountriesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCountriesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // DoGet handles to request to view the list of countries because no post request was sent
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Call on country helper to query table and return all rows  
		CountryHelper dao = new CountryHelper();
		// Passes a list of countries  to index
		request.setAttribute("allItems", dao.showAllCountries());
		String path = "/view-country.jsp";
		if(dao.showAllCountries().isEmpty()){
		path = "/view-country.jsp"; // redirect to index page if no countries exist in the database
		}
		// User redirected to index with an attribute called allitems that contains all countries in the database
		getServletContext().getRequestDispatcher(path).forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
