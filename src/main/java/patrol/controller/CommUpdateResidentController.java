package patrol.controller;

import java.io.IOException; 


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import patrol.dao.ResidentDAO;
import patrol.model.Resident;

/**
 * Servlet implementation class UpdateShawlController
 */
@WebServlet("/CommUpdateResidentController")
public class CommUpdateResidentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ResidentDAO dao;    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommUpdateResidentController() {
        super();
        dao = new ResidentDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int residentId = Integer.parseInt(request.getParameter("residentId"));
		request.setAttribute("s", ResidentDAO.getResidentDetail(residentId));
		RequestDispatcher view = request.getRequestDispatcher("comm UpdateRes.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Resident s = new Resident();
		s.setResidentId(Integer.parseInt(request.getParameter("residentId")));
		s.setResidentName(request.getParameter("residentName"));
		s.setResidentPassword(request.getParameter("residentPassword"));
		s.setResidentEmail(request.getParameter("residentEmail"));
		s.setResidentUsername(request.getParameter("residentUsername"));
		s.setResidentAddress(request.getParameter("residentAddress"));
		s.setResidentPhoneNum(Integer.parseInt(request.getParameter("residentPhoneNum")));
		
		
		dao.updateResident(s); 
		
		request.setAttribute("residents", ResidentDAO.getResidentDetails());
		RequestDispatcher view = request.getRequestDispatcher("ListResidentController");
		view.forward(request, response);
	}

}

