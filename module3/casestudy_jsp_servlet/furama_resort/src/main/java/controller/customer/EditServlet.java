package controller.customer;

import bean.Customer;
import common.Validate;
import service.customer.CustomerService;
import service.customer.Impl.CustomerServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "EditServlet", urlPatterns = "/editCustomer")
public class EditServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            request.setAttribute("customer", customerService.selectCus(id));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.getRequestDispatcher("jsp/customer/edit.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idCustomerType = Integer.parseInt(request.getParameter("idCustomerType"));
        String name = request.getParameter("name").trim();
        String birthDay = request.getParameter("birthDay").trim();
        String gender = request.getParameter("gender").trim();
        String idCard = request.getParameter("idCard").trim();
        String phone = request.getParameter("phone").trim();
        String email = request.getParameter("email").trim();
        String address = request.getParameter("address").trim();
        Customer customer = new Customer();
        Validate validate=new Validate();
        boolean check = true;
        if (name.equals("")) {
            request.setAttribute("msgName", "Enter incorrect name format");
            check = false;
        }else {
            customer.setCustomer_name(name);
        }
        if (!validate.checkIdCard(idCard)) {
            request.setAttribute("msgIdCard", "Enter incorrect Id Card format");
            check = false;
        } else {
            customer.setCustomer_id_card(idCard);
        }
        if (!validate.checkPhone(phone)) {
            request.setAttribute("msgPhone", "Enter incorrect phone format");
            check = false;
        } else {
            customer.setCustomer_phone(phone);
        }
        if (!validate.checkEmail(email)) {
            request.setAttribute("msgEmail", "Enter incorrect email format");
            check = false;
        } else {
            customer.setCustomer_email(email);
        }
        customer.setCustomer_id(id);
        customer.setCustomer_type_id(idCustomerType);
        customer.setCustomer_birthday(birthDay);
        customer.setCustomer_gender(gender);
        customer.setCustomer_address(address);
        if (!check) {
            request.setAttribute("customer",customer);
            request.getRequestDispatcher("jsp/customer/edit.jsp").forward(request, response);
        } else {
            try {
                if (customerService.updateCus(customer)) {
                    request.setAttribute("listCustomer", customerService.selectAllCus());
                    request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
