package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MarchingBand;

/**
 * Servlet implementation class EditBandServlet
 */
@WebServlet("/editBandServlet")
public class EditBandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBandServlet() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		MarchingBandHelper dao = new MarchingBandHelper ();
		String showName = request.getParameter("showName");
		Integer numOfMovements = Integer.parseInt(request.getParameter("numOfMovements"));
		Integer numOfMarchers = Integer.parseInt(request.getParameter("numOfMarchers"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		MarchingBand toEdit = dao.searchForBandById(tempId);
		toEdit.setShowName(showName);
		toEdit.setNumOfMovements(numOfMovements);
		toEdit.setNumOfMarchers(numOfMarchers);
		dao.updateBand(toEdit);
		getServletContext().getRequestDispatcher("/viewAllBandsServlet").forward(request, response);
	}

}
