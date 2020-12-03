package servlet;

import service.IUserService;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "cLogin", urlPatterns = "/cLogin")
public class CookieLogin extends HttpServlet {

    @Inject
    private IUserService userService;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var login = request.getParameter("uname");
        var secret = request.getParameter("psw");
        if (userService.verifyUser(login, secret)) {
            var cookie = new Cookie("currentUser", login);
            cookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie);
            response.sendRedirect("cLoginSuccess.jsp");
        } else {
            response.sendRedirect("loginFailed.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean isLogged = request.getCookies() != null &&
                Arrays.stream(request.getCookies()).anyMatch(cookie -> cookie.getName().equals("currentUser"));
        RequestDispatcher dispatcher;
        if (isLogged) {
            dispatcher = request.getRequestDispatcher("cPanel");
        } else  {
            dispatcher = request.getRequestDispatcher("cLogin.jsp");
        }
        dispatcher.forward(request, response);
    }
}
