package adlister;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "adlister.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String message;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (request.getMethod().equalsIgnoreCase("post")) {  //post method so we don't need this line
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if (username.equals("admin") && password.equals("password")) {
                HttpSession session = request.getSession();
                session.setAttribute("user", true);
                session.setAttribute("username", username);
                
                response.sendRedirect("/profile");
                out.print("Welcome, "+ username);
            } else {
                message = "Enter correct login and password.";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }
}
