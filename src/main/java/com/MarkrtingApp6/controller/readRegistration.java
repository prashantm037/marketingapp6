package com.MarkrtingApp6.controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MarkrtingApp6.model.DAOServiceImpl;

@WebServlet("/listall")
public class readRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public readRegistration() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		DAOServiceImpl service=new DAOServiceImpl();
	     service.connectDB();
	     
	     ResultSet result = service.readRegistration();
	     
	     request.setAttribute("result", result);
	     RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/showRegistration.jsp");
	     rd.forward(request, response);
	     
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
