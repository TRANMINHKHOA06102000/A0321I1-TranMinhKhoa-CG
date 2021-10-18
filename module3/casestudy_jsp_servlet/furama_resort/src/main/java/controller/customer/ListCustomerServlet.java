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

@WebServlet(name = "CustomerServlet", urlPatterns = "/customers")
public class ListCustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = null;
        try {
            customers = this.customerService.selectAllCus();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listCustomer", customers);
        request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
