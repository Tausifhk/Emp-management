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

@WebServlet("/delete")
public class deleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public deleteController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if (session.getAttribute("email")!=null) {
				String email = request.getParameter("emailId");
				
				DAOservice service= new DAOserviceImpl();
				service.connectDB();
				service.deleteRec(email);
				
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
