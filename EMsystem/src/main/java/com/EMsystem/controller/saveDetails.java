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


@WebServlet("/saveDetails")
public class saveDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public saveDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/addNewEmployee.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession(false);
			if (session.getAttribute("email")!=null) {
				String name = request.getParameter("name");
				String email = request.getParameter("email");
				String mobile = request.getParameter("mobile");
				String city = request.getParameter("city");
				String department = request.getParameter("department");
				String designation = request.getParameter("designation");
				String date = request.getParameter("date");
				String salary = request.getParameter("salary");
				
				DAOservice service=new DAOserviceImpl();
				service.connectDB();
				service.saveDetails(name, email, mobile, city, department, designation, date, salary);
				
				request.setAttribute("success", "Data has been saved successfully");
				RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/views/addNewEmployee.jsp");
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			}catch(Exception e)	{
				request.setAttribute("error", "Session time-out...login again");
				
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
	}

}
