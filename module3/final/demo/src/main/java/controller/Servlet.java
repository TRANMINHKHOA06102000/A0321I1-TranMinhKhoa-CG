package controller;

import model.bean.Customer;
import model.bean.CustomerType;
import model.service.CustomerService;
import model.service.CustomerTypeService;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.CustomerTypeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Servlet", urlPatterns = {"", "/customer"})
public class Servlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int typeId = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
        Map<String, String> mapMessage = customerService.edit(customer);
        if (!mapMessage.isEmpty()) {
            request.setAttribute("customer", customer);
            try {
                showUpdateForm(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                request.setAttribute("message", "sửa thành công");
                showList(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int idCustomerType = Integer.parseInt(request.getParameter("idCustomerType"));
        String name = request.getParameter("name");
        String birthDay = request.getParameter("birthDay");
        Boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(idCustomerType, name, birthDay, gender, idCard, phone, email, address);
        Map<String, String> mapMessage = customerService.create(customer);
        if (!mapMessage.isEmpty()) {
            request.setAttribute("customer", customer);
            try {
                showFormCreate(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                request.setAttribute("message", "thêm thành công");
                showList(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        customerService.delete(id);
        try {
            request.setAttribute("message", "xóa thành công");
            showList(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                try {
                    showFormCreate(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "update":
                try {
                    showUpdateForm(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "search":
                searchName(request, response);
                break;
            default:
                try {
                    showList(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        List<CustomerType> customerTypes = customerTypeService.findALl();
        request.setAttribute("customerTypes", customerTypes);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/customer/edit.jsp").forward(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("list", customerTypeService.findALl());
        request.getRequestDispatcher("/customer/create.jsp").forward(request, response);
    }

    private void searchName(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("nameSearch");
        String addressSearch = request.getParameter("addressSearch");
        String typeNameSearch = request.getParameter("typeNameSearch");
        List<Customer> customerList = null;
//        if (addressSearch == "" && typeNameSearch == "") {
//            customerList = customerService.findByContainName(name);
//        } else if (name == "" && typeNameSearch == ""){
//            customerList = customerService.findByContainAddress(addressSearch);
//        }else if (addressSearch == "" && name == ""){
//            customerList = customerService.findByContainTypeName(typeNameSearch);
//        }else {
//            customerList = customerService.findByContain(name, addressSearch, typeNameSearch);
//        }
        customerList=customerService.findByContain(name, addressSearch, typeNameSearch);
        request.setAttribute("customerList", customerList);
        try {
            request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("/customer/list.jsp").forward(request, response);
    }
}
