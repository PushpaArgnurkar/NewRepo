package com.cluster.servlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.io.IOException;

public class BoyServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body bgcolor='red'>");
		out.println("Welcome MR ");
		out.println("<form action='./apple' method='get'>");
		out.println("<table border='2'>");
		out.println("<tr>");
		out.println("<td>Enter your Name</td>");
		out.println("<td><input type='text' name='nme'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>Enter your Password</td>");
		out.println("<td><input type='password' name='pwd'></td>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td colspan='2' align='center'><input type='submit' value='Click Here'></td>");
		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
} 
