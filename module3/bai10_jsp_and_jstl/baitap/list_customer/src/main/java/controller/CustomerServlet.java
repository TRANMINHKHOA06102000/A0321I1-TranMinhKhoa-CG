package controller;

import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = {"","/CustomerServlet"})
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList=new ArrayList<>();
        customerList.add(new Customer("Jack","11/11/1990","Canada","https://img.vn/uploads/danhmuc/phuoc-dong-1564026880-c6z5u.jpg"));
        customerList.add(new Customer("Madam","11/11/1995","England","https://img.vn/uploads/danhmuc/phuoc-dong-1564026880-c6z5u.jpg"));
        customerList.add(new Customer("Ken","11/11/1996","Japan","https://img.vn/uploads/danhmuc/phuoc-dong-1564026880-c6z5u.jpg"));
        customerList.add(new Customer("Tim","11/11/1997","Spain","https://img.vn/uploads/danhmuc/phuoc-dong-1564026880-c6z5u.jpg"));

        request.setAttribute("customerFromServlet",customerList);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
