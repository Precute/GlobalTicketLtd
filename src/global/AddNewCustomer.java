package global;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AddNewCustomer
 */
@WebServlet("/add-customer")
public class AddNewCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewCustomer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOCustomer cconnect = new DAOCustomer();
		DAOLogin lconnect = new DAOLogin();
		int custID =0;
		String userType = "customer";
		String fName = request.getParameter("") ;
		String oName =request.getParameter("") ;
		String lName =request.getParameter("");
		String cAddress =request.getParameter(""); 
		String cPostcode =request.getParameter("");
		String cCity =request.getParameter("");
		String cCountry =request.getParameter("");
		String cDOB =request.getParameter(""); 
		String cEmail =request.getParameter("");
		String cTel =request.getParameter("");
		String cMob =request.getParameter("");
		BeanCustomer c = new BeanCustomer( fName,  oName, lName,  cAddress, cPostcode, 
				cCity, cCountry, cDOB,  cEmail,  cTel,  cMob);
		cconnect.add(c);
		
		 c = cconnect.findCustByEmailAndPostcode(cEmail, cPostcode);
		custID = c.getCustID();
			
		String username, password;
		username = request.getParameter("");
		password = request.getParameter("");
		BeanLogin l = new BeanLogin(custID, username, password, userType);
		lconnect.addUser(l); 
	}

}
