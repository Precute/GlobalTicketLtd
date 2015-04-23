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

/** 
 */
@WebServlet("/delete-item")
public class DeleteFromOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAOAttraction aconnect = new DAOAttraction();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteFromOrder() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			//declare session
			HttpSession session = request.getSession(true);
			synchronized (session) {
				@SuppressWarnings("unchecked")
				//retrieve list from session
				List<String> previousItems = (List<String>) session
						.getAttribute("previousItems");
				
				
				String item = request.getParameter("tkt");
				System.out.println(item);
					if (request.getParameter("tkt") != null) {
					//remove item
						previousItems.remove(item);
					
					
					session.setAttribute("previousItems", previousItems); 
					}
			//forward to basket after removal
			RequestDispatcher requestDispatcher = 
					request.getRequestDispatcher("/basket.jsp");
				requestDispatcher.forward(request, response);
				return;
		}
	}
}


