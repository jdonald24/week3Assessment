package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CompetitionClassification;


/**
 * Servlet implementation class DeleteCompetitionServlet
 */
@WebServlet("/deleteCompetitionServlet")
public class DeleteCompetitionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCompetitionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		CompetitionClassificationHelper dao = new CompetitionClassificationHelper();
		String act = request.getParameter("doThisToCompetition");

		if (act == null) {
			// no button has been selected
			getServletContext().getRequestDispatcher("/viewAllCompetitionsServlet").forward(request, response);

		} else  {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				CompetitionClassification listToDelete = dao.searchForCompetitionClassificationById(tempId);
				dao.deleteCompetition(listToDelete);

			} catch (NumberFormatException e) {
				System.out.println("Forgot to click a button");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllCompetitionsServlet").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
