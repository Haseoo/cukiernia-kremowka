package pl.cukiernia.kremowka.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "CookieLogout", urlPatterns = "/cLogout")
public class CookieLogout extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getCookies() != null) {
            var cookie = Arrays.stream(request.getCookies()).filter(c -> c.getName().equals("currentUser")).findAny();
            cookie.ifPresent( c-> {
                    c.setMaxAge(0);
                    response.addCookie(c);
                }
            );
        }
        var dispatcher = request.getRequestDispatcher("logoutSuccess.jsp");
        dispatcher.forward(request, response);
    }
}
