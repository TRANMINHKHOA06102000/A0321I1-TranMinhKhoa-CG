package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductDiscountServlet", value = "/ProductDiscountServlet")
public class ProductDiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        double listPrice = Double.parseDouble(request.getParameter("price"));
        double discountPercent = Double.parseDouble(request.getParameter("discount-percent"));
        double discountAmount = listPrice * discountPercent * 0.01;
        double discountPrice = listPrice - discountAmount;

        request.setAttribute("descriptionFromServer",description);
        request.setAttribute("listPriceFromServer",listPrice);
        request.setAttribute("discountPercentFromServer",discountPercent);
        request.setAttribute("discountAmountFromServer",discountAmount);
        request.setAttribute("discountPriceFromServer",discountPrice);
        request.getRequestDispatcher("result.jsp")
                .forward(request, response);
    }
}
