package global;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MakeEnquiry
 */
@WebServlet("/send-enquiry")
public class MakeEnquiry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public MakeEnquiry() {
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
		String eqyDs = request.getParameter("enquirydetail");
		String enqDt = request.getParameter("enqdate");
		int cID = Integer.parseInt(request.getParameter("custid"));		
		BeanEnquiry enq = new BeanEnquiry( eqyDs, enqDt,  cID );
		enqconncet.add(enq);
		RequestDispatcher requestDispatcher = 
				request.getRequestDispatcher("/customer-account.jsp");
			requestDispatcher.forward(request, response);
			return;
	}

}
