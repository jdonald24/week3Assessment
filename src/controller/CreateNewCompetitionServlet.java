package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Competition;
import model.CompetitionClassification;
import model.MarchingBand;

/**
 * Servlet implementation class CreateNewCompetitionServlet
 */
@WebServlet("/createNewCompetitionServlet")
public class CreateNewCompetitionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateNewCompetitionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String competitionClassification = request.getParameter("competitionClassification");
		String competitionName = request.getParameter("competitionName");
		int numOfJudges = Integer.parseInt(request.getParameter("numOfJudges"));
		int numOfBands = Integer.parseInt(request.getParameter("numOfBands"));
		MarchingBandHelper MBH = new MarchingBandHelper();
		String [] selectedBands = request.getParameterValues("allBandsToAdd");
		List<MarchingBand> selectedBandsInList = new ArrayList<MarchingBand>();
		if(selectedBands != null && selectedBands.length > 0) {
			for(int i = 0; i < selectedBands.length; i++) {
				MarchingBand c =MBH.searchForBandById(Integer.parseInt(selectedBands[i]));
				selectedBandsInList.add(c);
			}
		}
		Competition competition = new Competition(competitionName, numOfJudges, numOfBands);
		CompetitionClassification cc = new CompetitionClassification (competitionClassification, competition, selectedBandsInList);
		CompetitionClassificationHelper CCH = new CompetitionClassificationHelper();
		CCH.insertNewCompetitionClassification(cc);
		getServletContext().getRequestDispatcher("/viewAllCompetitionsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
