//When a user visits /logout, they should be logged out of your application and redirected to the login page.

package adlister;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "adlister.LogoutServlet", urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        HttpSession session = request.getSession();
        session.invalidate();

        out.print("You are successfully logged out!");
        request.getRequestDispatcher("/login.jsp").include(request, response);
        
        out.close();
    }
}