package com.codeup.adlister.controllers;

import com.mysql.cj.jdbc.Driver;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.DriverManager;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // TODO: find a record in your database that matches the submitted password
//        String selectQuery = "SELECT * FROM movies";
//        DriverManager.registerDriver(new Driver());
//        Connection connection = DriverManager.getConnection(
//                "jdbc:mysql://localhost/movies_db?serverTimezone=UTC&useSSL=false",
//                "someuser",
//                "strongpassword"
//        );
//        Statement stmt = connection.createStatement();
//        ResultSet rs = stmt.executeQuery(selectQuery);
//        while (rs.next()) {
//            System.out.println("Here's a movie:");
//            System.out.println("  id: " + rs.getLong("id"));
//            System.out.println("  title: " + rs.getString("title"));
//        }






        // TODO: make sure we find a user with that username
        // TODO: check the submitted password against what you have in your database
        boolean validAttempt = true;

        if (validAttempt) {
            // TODO: store the logged in user object in the session, instead of just the username
            request.getSession().setAttribute("user", username);
            response.sendRedirect("/profile");
        } else {
            response.sendRedirect("/login");
        }
    }
}
