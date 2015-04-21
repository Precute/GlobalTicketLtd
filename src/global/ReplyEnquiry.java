package global;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReplyEnquiry
 */
@WebServlet("/reply-enquiry")
public class ReplyEnquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyEnquiry() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAOEnquiry enqconncet = new DAOEnquiry ();
		int ID = Integer.parseInt(request.getParameter("enqid"));
		String eqyNote = request.getParameter("enquirynote");
		int eID = Integer.parseInt(request.getParameter("empid"));		
		BeanEnquiry enq = new BeanEnquiry( eqyNote, eID );
		enqconncet.updateEnquiry( ID, eqyNote, eID);
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher("/employee-account.jsp");
			requestDispatcher.forward(request, response);
			return;
	}

}
