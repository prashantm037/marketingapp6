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

@WebServlet("/save")
public class saveregistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public saveregistration() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/createRegistration.jsp");
	       rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");
        
        DAOService service=new DAOServiceImpl();
        service.connectDB();
        
        service.saveRegistration(name, city, email, mobile);
        
        request.setAttribute("msg", "Registration is Done");
        RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/createRegistration.jsp");
	       rd.forward(request, response);
        
	}

}
