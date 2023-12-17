package com.EMsystem.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.EMsystem.model.DAOservice;
import com.EMsystem.model.DAOserviceImpl;


@WebServlet("/verify")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		
		//Connecting to Database
		DAOservice service = new DAOserviceImpl();
		service.connectDB();
		
		//verifying credentials
		boolean status = service.verifyCredentials(email, password);
		if (status==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email",email);
			session.setMaxInactiveInterval(60);
			
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/addNewEmployee.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("error", "Invalid username/password");
			RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
			rd.forward(request, response);
		}
	}
}
