package com.cluster.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GirlCheckServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String strName = request.getParameter("nme");
		String strPassword = request.getParameter("pwd");
		if (strName.equalsIgnoreCase("sita")
				&& strPassword.equalsIgnoreCase("gita")) {
			writer.println("<html>");
			writer.println("<body bgcolor='yellow'>");
			writer.println("Hello Ms " + strName + " you are Welcome");
			writer.println("</body>");
			writer.println("</html>");
		} else {
			writer.println("<html>");
			writer.println("<html>");
			writer.println("<body bgcolor='pink'>");
			writer.println("Hello Ms " + strName + " you are Not Welcome");
			writer.println("</body>");
			writer.println("</html>");
		}

	}

}
