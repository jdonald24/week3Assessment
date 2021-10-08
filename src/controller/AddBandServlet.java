package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MarchingBand;

/**
 * Servlet implementation class AddBandServlet
 */
@WebServlet("/addBandServlet")
public class AddBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBandServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String showName = request.getParameter("showName");
		Integer numOfMovements = Integer.parseInt(request.getParameter("numOfMovements"));
		Integer numOfMarchers = Integer.parseInt(request.getParameter("numOfMarchers"));
		MarchingBand MB = new MarchingBand (numOfMovements, numOfMarchers, showName);
		MarchingBandHelper dao = new MarchingBandHelper();
		dao.insertBand(MB);
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}
