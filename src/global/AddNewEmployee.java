package global;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddNewEmployee
 */
@WebServlet("/add-employee")
public class AddNewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddNewEmployee() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEmployee econnect = new DAOEmployee();
		DAOLogin loconnect = new DAOLogin();
		int empID;
		String userType = "employee";
		String fName = request.getParameter("empfname");
		String oName = request.getParameter("emponame");
		String lName = request.getParameter("emplname");
		String DOB = request.getParameter("empdob");
		String startDate = request.getParameter("startdate");
		float salary = Float.parseFloat(request.getParameter("empsalary"));
		String eEmail  = request.getParameter("empemail");
		String tel = request.getParameter("emptel");
		String role = request.getParameter("emprole"); 
			
		BeanEmployee emp = new BeanEmployee(fName, oName, lName, DOB, startDate, salary, eEmail, tel, role);
		econnect.add(emp);
		 emp = econnect.findEmpByEmailAndLastname(eEmail, lName);
			empID = emp.getEmpID();
		String username, password;
		username = request.getParameter("empusername");
		password = request.getParameter("emppassword");
		BeanLogin l = new BeanLogin(empID, username, password, userType);
		loconnect.addUser(l);
	}

}
