package pl.cukiernia.kremowka.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "CookiePanel", urlPatterns = "/cPanel")
public class CookiePanel extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isLogged = request.getCookies() != null &&
                Arrays.stream(request.getCookies()).anyMatch(cookie -> cookie.getName().equals("currentUser"));
        RequestDispatcher dispatcher;
        if (isLogged) {
            var cookie = Arrays.stream(request.getCookies()).
                    filter(c -> c.getName().equals("currentUser"))
                    .findAny()
                    .orElseThrow(AssertionError::new);
            request.setAttribute("cUser", cookie.getValue());
            dispatcher = request.getRequestDispatcher("cPanel.jsp");
        } else  {
            dispatcher = request.getRequestDispatcher("cLogin");
        }
        dispatcher.forward(request, response);
    }
}
