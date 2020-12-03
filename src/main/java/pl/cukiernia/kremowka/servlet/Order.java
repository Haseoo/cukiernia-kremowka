package pl.cukiernia.kremowka.servlet;

import pl.cukiernia.kremowka.views.OrderView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Order", urlPatterns = "/zamow")
public class Order extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var session = request.getSession(false);
        if (session == null || session.isNew()) {
            response.sendRedirect("sessionError.jsp");
        } else {
            var product = request.getParameter("product");
            var qty = Integer.parseInt(request.getParameter("qty"));
            var personalInfo = request.getParameter("personalInfo");
            var order = new OrderView(product, qty, personalInfo);
            session.setAttribute("order", order);
            response.encodeRedirectURL("/");
            response.sendRedirect("zamow/finish");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var session = request.getSession(true);
        session.setMaxInactiveInterval(300);
        response.encodeRedirectURL("/");
        var dispatcher = request.getRequestDispatcher("orderForm.jsp");
        dispatcher.forward(request, response);
    }
}
