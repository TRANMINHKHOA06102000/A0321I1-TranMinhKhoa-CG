package controller.customer;

import bean.Customer;
import service.customer.CustomerService;
import service.customer.Impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchServlet", urlPatterns = "/searchCustomer")
public class SearchServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<Customer> listCustomer = null;
        try {
            listCustomer = customerService.findCus(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listCustomer", listCustomer);
        request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
    }
}
