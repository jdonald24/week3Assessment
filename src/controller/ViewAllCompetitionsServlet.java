package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CompetitionClassification;
import model.MarchingBand;

/**
 * Servlet implementation class ViewAllCompetitionsServlet
 */
@WebServlet("/viewAllCompetitionsServlet")
public class ViewAllCompetitionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAllCompetitionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		CompetitionClassificationHelper CCH = new CompetitionClassificationHelper();
		List<CompetitionClassification> allBands = CCH.getCompetitions();
		request.setAttribute("allCompetitions", allBands);
		if(allBands.isEmpty()) {
			request.setAttribute("allBands", "");
		}
		getServletContext().getRequestDispatcher("/view-all-competitions.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
