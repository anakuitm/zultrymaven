package patrol.controller;

import jakarta.servlet.RequestDispatcher; 
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import patrol
import patrol.model.Patrolman;
import patrol.dao.PatrolmanDAO;

import java.io.IOException;

/**
 * Servlet implementation class viewSchedule
 */
public class viewPatrolman extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PatrolmanDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewPatrolman() {
        super();
        dao = new PatrolmanDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String patrolmanId = request.getParameter("patrolmanId");
		request.setAttribute("patrolman",PatrolmanDAO.getPatrolmanDetails());
		RequestDispatcher view = request.getRequestDispatcher("comm viewPat.jsp"); //schedule page
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
