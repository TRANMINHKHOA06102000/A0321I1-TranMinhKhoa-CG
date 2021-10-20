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

@WebServlet(name = "CreateServlet", urlPatterns = "/createCustomer")
public class CreateServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/customer/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Validate idCardValidate = new Validate("^\\d{9}$|^\\d{12}$");
        Validate phoneValidate = new Validate("^09[0-1]\\d{7}$|^\\(84\\)\\+9[0-1]\\d{7}$");
        Validate emailValidate = new Validate("^[a-zA-Z][\\w-]+@([\\w]+\\.[\\w]+|[\\w]+\\.[\\w]{2,}\\.[\\w]{2,})$");
        int idCustomerType = Integer.parseInt(request.getParameter("idCustomerType").trim());
        String name = request.getParameter("name").trim();
        String birthDay = request.getParameter("birthDay").trim();
        String gender = request.getParameter("gender").trim();
        String idCard = request.getParameter("idCard").trim();
        String phone = request.getParameter("phone").trim();
        String email = request.getParameter("email").trim();
        String address = request.getParameter("address").trim();
        Customer customer = new Customer();
        boolean check = true;
        if (name.equals("")) {
            request.setAttribute("msgName", "Enter incorrect name format");
            check = false;
        } else {
            customer.setCustomer_name(name);
        }
        if (!idCardValidate.checkRegex(idCard)) {
            request.setAttribute("msgIdCard", "Enter incorrect Id Card format");
            check = false;
        } else {
            customer.setCustomer_id_card(idCard);
        }
        if (!phoneValidate.checkRegex(phone)) {
            request.setAttribute("msgPhone", "Enter incorrect phone format");
            check = false;
        } else {
            customer.setCustomer_phone(phone);
        }
        if (!emailValidate.checkRegex(email)) {
            request.setAttribute("msgEmail", "Enter incorrect email format");
            check = false;
        } else {
            customer.setCustomer_email(email);
        }
        customer.setCustomer_type_id(idCustomerType);
        customer.setCustomer_birthday(birthDay);
        customer.setCustomer_gender(gender);
        customer.setCustomer_address(address);
        if (!check) {
            request.getRequestDispatcher("jsp/customer/create.jsp").forward(request, response);
        } else {
            try {
                if (customerService.insertCus(customer)) {
                    request.setAttribute("listCustomer", customerService.selectAllCus());
                    request.getRequestDispatcher("jsp/customer/list.jsp").forward(request, response);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
