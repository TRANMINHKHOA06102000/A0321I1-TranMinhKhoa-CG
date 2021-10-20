package controller.service;

import bean.Service;
import service.service.ServiceFurama;
import service.service.impl.ServiceFuramaImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/services")
public class ListServiceServlet extends HttpServlet {
    private ServiceFurama serviceFurama = new ServiceFuramaImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> services = null;
        try {
            services = this.serviceFurama.selectAllService();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listServices", services);
        request.getRequestDispatcher("jsp/service/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
