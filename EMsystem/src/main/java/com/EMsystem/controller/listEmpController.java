package com.EMsystem.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EMsystem.model.DAOservice;
import com.EMsystem.model.DAOserviceImpl;

@WebServlet("/listEmp")
public class listEmpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public listEmpController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean userPrefersDarkMode = fetchUserDarkModePreference(request);
		try {
			HttpSession session = request.getSession(false);
			session.setAttribute("darkMode", userPrefersDarkMode);
			if (session.getAttribute("email")!=null) {
			
			DAOservice service = new DAOserviceImpl();
			
			service.connectDB();
			ResultSet employees=service.listEmp();
			
			request.setAttribute("employees", employees);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/employeesList.jsp");
			rd.forward(request, response);
			}else {
				request.setAttribute("error", "login first");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "Session time-out...login again");
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
	}
	private boolean fetchUserDarkModePreference(HttpServletRequest request) {
		String darkModePreference = (String) request.getParameter("darkMode");
	    return "true".equalsIgnoreCase(darkModePreference);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
