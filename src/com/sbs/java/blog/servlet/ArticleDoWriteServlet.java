package com.sbs.java.blog.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/article/doWrite")
public class ArticleDoWriteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		String url = "jdbc:mysql://localhost:3309/blog?serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true";
		String user = "sen";
		String password = "1234";
		String driverName = "com.mysql.cj.jdbc.Driver";

		Connection connection;

		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
			response.getWriter().append("연결되었습니다.");
		} catch (SQLException e) {
			System.err.printf("[SQL 예외] : %s\n", e.getMessage());
		} catch (ClassNotFoundException e) {
			System.err.printf("[드라이버 클래스 로딩 예외] : %s\n", e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
