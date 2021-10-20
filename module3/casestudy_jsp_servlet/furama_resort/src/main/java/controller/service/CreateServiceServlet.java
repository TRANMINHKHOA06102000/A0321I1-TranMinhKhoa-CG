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

@WebServlet(name = "CreateServiceServlet", urlPatterns = "/createService")
public class CreateServiceServlet extends HttpServlet {
    private ServiceFurama serviceFurama = new ServiceFuramaImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/service/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //int service_id = Integer.parseInt(request.getParameter("service_id"));
        String service_name = request.getParameter("service_name");
        int service_area = Integer.parseInt(request.getParameter("service_area"));
        double service_cost = Double.parseDouble(request.getParameter("service_cost"));
        int service_max_people = Integer.parseInt(request.getParameter("service_max_people"));
        int rent_type_id = Integer.parseInt(request.getParameter("rent_type_id"));
        int service_type_id = Integer.parseInt(request.getParameter("service_type_id"));
        String standard_room = request.getParameter("standard_room");
        String description_other_convenience = request.getParameter("description_other_convenience");
        double pool_area = Double.parseDouble(request.getParameter("pool_area"));
        int number_of_floors = Integer.parseInt(request.getParameter("number_of_floors"));
        Service service = new Service(service_name, service_area, service_cost, service_max_people,
                rent_type_id, service_type_id, standard_room, description_other_convenience, pool_area, number_of_floors);
        try {
            if (serviceFurama.insertService(service)) {
                request.setAttribute("listServices", serviceFurama.selectAllService());
                request.getRequestDispatcher("jsp/service/list.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/service/create.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
