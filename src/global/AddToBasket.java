package global;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/** 13153439 Huseyin Arpalikli
 * Servlet implementation class AddToBasket
 * Servlet to add an item to a basket
 */
@WebServlet("/add-to-order")
public class AddToBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOAttraction aconnect = new DAOAttraction();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToBasket() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//declare variables
		ArrayList<BeanAttraction> att;
		
		//initialise variables
		att = aconnect.findAttByID(Integer.parseInt(request.getParameter("ticket")));
		int availability = 0;
		//statement to get stock count
		
			for (BeanAttraction a : att) {
				availability = a.getAttAvailabilityCount();
			}

		//send to error page when stock is 0, otherwise add to basket
		if (availability == 0) {
			RequestDispatcher requestDispatcher = request
					.getRequestDispatcher("/error-outofstock.jsp");
			requestDispatcher.forward(request, response);
			return;
		} else {

			HttpSession session = request.getSession(true);
			synchronized (session) {
				@SuppressWarnings("unchecked")
				List<String> previousItems = (List<String>) session
						.getAttribute("previousItems");
				
				if (previousItems == null) {
					previousItems = new ArrayList<String>();
					// add array to session	
					session.setAttribute("previousItems", previousItems); 
																				
				}
				// find out the AttrID passed in 
				String newItem = request.getParameter("ticket");
				//send to error if item already in basket otherwise add to basket
				if(previousItems.contains(newItem)){
					RequestDispatcher requestDispatcher = request
							.getRequestDispatcher("/error-inbasket.jsp");
					requestDispatcher.forward(request, response);
					return;
					}else
				if ((newItem != null) && (!newItem.trim().equals(""))) {
					previousItems.add(newItem);
					session.setAttribute("previousItems", previousItems);
				}

				for (int pos = 0; pos < previousItems.size(); pos++) {
					String item = previousItems.get(pos);
					System.out.println(item);
				}
					
				}
				}
				System.out.println("END");
				//after adding to basket, display basket page
				RequestDispatcher requestDispatcher = request
						.getRequestDispatcher("/basket.jsp");
				requestDispatcher.forward(request, response);
				return;
			}

}
