package jp.co.aforce.all;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import jp.co.aforce.tool.Page;

@WebServlet(urlPatterns={"/jp.co.aforce.all/all"})
public class All extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Page.header(out);
		
		try {
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource)ic.lookup("java:/comp/env/jdbc/employee");
			Connection con = ds.getConnection();
			
			PreparedStatement ps = con.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				out.println(rs.getString("user_id"));
				out.println(":");
				out.println(rs.getString("password"));
				out.println(":");
				out.println(rs.getString("name"));
				out.println("<br>");
				
			}
			
			ps.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace(out);
			
		}
		
		Page.footer(out);
		
	}
}
