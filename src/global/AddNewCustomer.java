package global;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
		int custID;
		String userType = "customer";
		String fName = request.getParameter("custfname") ;
		String oName =request.getParameter("custoname") ;
		String lName =request.getParameter("custlname");
		String cAddress =request.getParameter("custaddress"); 
		String cPostcode =request.getParameter("custpostcode");
		String cCity =request.getParameter("custcity");
		String cCountry =request.getParameter("custcountry");
		String cDOB =request.getParameter("custdob"); 
		String cEmail =request.getParameter("custemail");
		String cTel =request.getParameter("custtel");
		String cMob =request.getParameter("custmob");
		BeanCustomer c = new BeanCustomer( fName,  oName, lName,  cAddress, cPostcode, 
				cCity, cCountry, cDOB,  cEmail,  cTel,  cMob);
		cconnect.add(c);
		
		 c = cconnect.findCustByEmailAndPostcode(cEmail, cPostcode);
		custID = c.getCustID();
			
		String username, password;
		username = request.getParameter("custusername");
		password = request.getParameter("custpassword");
		
		BeanLogin l = new BeanLogin(custID, username, password, userType);
		lconnect.addUser(l); 
		
	}

}
