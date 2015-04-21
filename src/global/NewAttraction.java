package global;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewAttraction
 */
@WebServlet("/update-catalogue")
public class NewAttraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewAttraction() {
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
		
	DAOAttraction aconnect = new DAOAttraction ();
	int attractionID;
	String aName = request.getParameter("attname");
	String aDescript = request.getParameter("attdescript");
	String aDescript1 = request.getParameter("attdescript1");
	int attNo =Integer.parseInt(request.getParameter("attnumber")) ;
	int attType = Integer.parseInt(request.getParameter("atttype"));
	int attLocation = Integer.parseInt(request.getParameter("attlocation"));
	
	BeanAttraction a = new BeanAttraction ( aName, aDescript, aDescript1, attNo, attType, attLocation);
	aconnect.add(a);
	
	a = aconnect.findAllCatalogue(aName,aDescript); 
	attractionID = a.getAttractionID() ;
	
	int tktType = Integer.parseInt(request.getParameter("type"));
	double tktPrice = Double.parseDouble(request.getParameter("price"));
	
	BeanAttraction ab = new BeanAttraction(attractionID,tktType, tktPrice);
	aconnect.addPrice(ab);
	
	}

}
