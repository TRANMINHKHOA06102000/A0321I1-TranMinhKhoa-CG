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

@WebServlet(name = "DeleteServlet", urlPatterns = "/deleteCustomer")
public class DeleteServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            customerService.deleteCus(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<Customer> customerList = null;
        try {
            customerList = customerService.selectAllCus();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listCustomer", customerList);
        request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
