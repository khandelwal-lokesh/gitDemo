package com.register;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Employee;





@WebServlet(urlPatterns="/register")
public class RegisterServlet extends HttpServlet 
{
		@Override
		protected void service(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException 
		{
		Employee emp=new Employee();
		emp.setEid(Integer.parseInt(request.getParameter("eid")));
		emp.setName(request.getParameter("name"));
		emp.setAddress(request.getParameter("address"));
		emp.setUsername(request.getParameter("username"));
		emp.setPassword(request.getParameter("password"));
		
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
				String sql="insert into employee values(?,?,?,?,?)";
				
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, emp.getEid());
				ps.setString(2, emp.getName());
				ps.setString(3, emp.getAddress());
				ps.setString(4, emp.getUsername());
				ps.setString(5, emp.getPassword());
				ps.execute();
				
				
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		RequestDispatcher rd=request.getRequestDispatcher("login.html");
		
		rd.forward(request, response);
		}
	}


