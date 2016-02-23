package com.cluster.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DBCheckServlet extends HttpServlet {
	boolean blnIsValid = false;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//boolean blnIsValid = false;
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String strName = request.getParameter("name");
		String strPassword = request.getParameter("password");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:krishna", "scott", "tiger");
			
			System.out.println("************1" + connection);
			Statement statement = connection.createStatement();
			System.out.println("************2" + statement);
			ResultSet resultSet = statement.executeQuery("select name,password from uday");
			System.out.println("************3" + resultSet);
			
			while (resultSet.next()) {
				if ((strName.equalsIgnoreCase(resultSet.getString("name")))
						&& (strPassword.equalsIgnoreCase(resultSet
								.getString("password")))) {
					blnIsValid = true;
					break;
				}
			}
			if (blnIsValid) {
				writer.println("<html>");
				writer.println("<body bgcolor='yellow'>");
				writer.println("Hello Mr " + strName + " you are Welcome");
				writer.println("</body>");
				writer.println("</html>");
			} else {
				writer.println("<html>");
				writer.println("<html>");
				writer.println("<body bgcolor='pink'>");
				writer.println("Hello Mr " + strName + " you are Not Welcome");
				writer.println("</body>");
				writer.println("</html>");

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
