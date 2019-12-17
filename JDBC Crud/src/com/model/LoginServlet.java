package com.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns="/log")
public class LoginServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String UserName=request.getParameter("user");
		String Password=request.getParameter("pass");
		
	if(UserName.equals("admin")&&Password.equals("admin"))	
	{	
		try
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
				String sql="select * from employee";
				Statement smt=con.createStatement();
					ResultSet rs=smt.executeQuery(sql);
					List<Employee> elist=new ArrayList<>();
				while(rs.next())
				{
					
					Employee e= new Employee();	
					e.setEid(rs.getInt(1));
					e.setName(rs.getString(2));
					e.setAddress(rs.getString(3));
					e.setUsername(rs.getString(4));
					e.setPassword(rs.getString(5));
					
					elist.add(e);
					
				}
				request.setAttribute("einfo",elist);
				RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
				rd.forward(request, response);
		   }
				catch(Exception e)
				{
					System.out.println(e.getMessage());
					
				}
		}
	/*			else
				{
	
					request.setAttribute("String","Username or password is incorrect....");
					RequestDispatcher rd=request.getRequestDispatcher("index.html");
					rd.forward(request, response);
				}*/
	}
		
}