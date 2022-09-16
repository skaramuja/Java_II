package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TruthOrDare;

/**
 * Servlet implementation class getTruthOrDare
 */
@WebServlet("/getTruthOrDare")
public class getTruthOrDare extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getTruthOrDare() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String truthOrDare = request.getParameter("truth");
		TruthOrDare selection = new TruthOrDare(truthOrDare);
		request.setAttribute("selection", selection);
		getServletContext().getRequestDispatcher("/result.jsp").forward(request, response);
	}

}
