package global;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 
 * Servlet implementation class LoginProcess
 * Servlet to process the user login
 */
@WebServlet("/loginprocess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//declare variables
		DAOLogin lconnect = new DAOLogin();
		String usrType;
		String user=request.getParameter("username");  
		String pass=request.getParameter("userpass");  
		BeanLogin usr = null;
		//check if user and password match database    
		if(lconnect.validateLogin(user, pass)){ 
		    	usr=lconnect.retrieveUser(user, pass);
		    	usrType= usr.getUserType();
		    	//retrieve user and carry out following based on user type
		    	if(usrType.equals("customer")){
		    		//create cookies and send redirect to customer area 
		    		Cookie ck=new Cookie("username", user);
		    		 ck.setMaxAge(-1); //till end of session
		             response.addCookie(ck);   
		             Cookie type=new Cookie("usertype", usrType);
		             type.setMaxAge(-1); //till end of session
		             response.addCookie(type);   
		             response.sendRedirect("customer-account.jsp");	
		    	}else if(usrType.equals("admin")){
		    		//create cookies and send redirect to admin area
		    		Cookie ck=new Cookie("username",user);  
		    		ck.setMaxAge(-1); //till end of session
		    		response.addCookie(ck); 
		             Cookie type=new Cookie("usertype", usrType);
		             type.setMaxAge(-1); //till end of session
		             response.addCookie(type); 
		    		response.sendRedirect("employee-account.jsp");  	 
		    	}else if(usrType.equals("employee")){
		    		//create cookies and send redirect to employee area
		    		Cookie ck=new Cookie("username",user);  
		    		ck.setMaxAge(-1); //till end of session
		    		response.addCookie(ck); 
		             Cookie type=new Cookie("usertype", usrType);
		             type.setMaxAge(-1); //till end of session
		             response.addCookie(type); 
		    		response.sendRedirect("employee-account.jsp");  	 
		    }  //alternative forwarding if username or password is incorrect
		    	}else{  
		    	request.setAttribute("errorMessage", "Sorry, username or password incorrect!");
		    	RequestDispatcher rd=request.getRequestDispatcher("login.jsp");  
		    	rd.forward(request,response);  
		    }  
		            
		 
	}

}
