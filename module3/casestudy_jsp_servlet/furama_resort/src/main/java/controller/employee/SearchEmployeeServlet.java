package controller.employee;

import bean.Employee;
import service.employee.EmployeeService;
import service.employee.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "SearchEmployeeServlet", urlPatterns = "/searchEmployee")
public class SearchEmployeeServlet extends HttpServlet {
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("search");
        List<Employee> employeeList = null;
        try {
            employeeList = employeeService.findEmp(name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listEmployee", employeeList);
        request.getRequestDispatcher("jsp/employee/list.jsp").forward(request, response);
    }
}
