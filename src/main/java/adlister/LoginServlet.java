package adlister;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "adlister.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        if (request.getMethod().equalsIgnoreCase("post")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username.equals("admin") && password.equals("password")) {
                response.sendRedirect("/profile");
            } else {
                response.sendRedirect("/login.jsp");

            }
        }
    }
}
