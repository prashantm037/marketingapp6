package com.MarkrtingApp6.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MarkrtingApp6.model.DAOService;
import com.MarkrtingApp6.model.DAOServiceImpl;

@WebServlet("/login")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public controller() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String email = request.getParameter("email");
     String password = request.getParameter("password");
     
     DAOService service=new DAOServiceImpl();
	  service.connectDB();
	  
	  boolean status = service.varifrycredintial(email, password);
	  
	  if (status==true) {
		  RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/createRegistration.jsp");
	       rd.forward(request, response);
	} else {
		request.setAttribute("error", "Invalid Username/password");
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
       rd.forward(request, response);
	}
	
	}

}
