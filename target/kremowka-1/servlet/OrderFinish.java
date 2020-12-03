package servlet;

import views.OrderView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderFinish", urlPatterns = "/zamow/finish")
public class OrderFinish extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("../sessionError.jsp");
        } else {
            OrderView order = (OrderView)session.getAttribute("order");
            if (order == null) {
                response.sendRedirect("../sessionError.jsp");
            } else {
                session.removeAttribute("order");
                var dispatcher = request.getRequestDispatcher("../orderSummary.jsp");
                request.setAttribute("order", order);
                dispatcher.forward(request, response);
            }
        }
    }
}
