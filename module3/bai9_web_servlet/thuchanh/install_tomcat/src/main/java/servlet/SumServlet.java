package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "SumServlet", value = "/sumServlet")
public class SumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String a = request.getParameter("number1");
        String b = request.getParameter("number2");
        int c = Integer.parseInt(a) + Integer.parseInt(b);

        request.setAttribute("resultFromServlet", c);
        request.getRequestDispatcher("result_final.jsp")
                .forward(request, response);

        //response.sendRedirect("result_final.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
