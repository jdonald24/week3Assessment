package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.MarchingBand;

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
		MarchingBandHelper dao = new MarchingBandHelper();
		String toDo = request.getParameter("doThisToBand");
		String path = "/viewAllBandsServlet";
		if(toDo.equals("delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				MarchingBand bandToDelete = dao.searchForBandById(tempId);
				dao.deleteBand(bandToDelete);
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select a band.");
			}
		} else if (toDo.equals("edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				MarchingBand bandToEdit = dao.searchForBandById(tempId);
				request.setAttribute("bandToEdit", bandToEdit);
				path = "/edit-band.jsp";
			} catch (NumberFormatException e) {
				System.out.println("Forgot to select an item.");
			}
		} else if (toDo.equals("add")) {
			path = "/index.html";
		}
		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
