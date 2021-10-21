package controller.contract;

import bean.Contract;
import bean.Employee;
import service.contract.ContractService;
import service.contract.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateContractServlet", urlPatterns = "/createContract")
public class CreateContractServlet extends HttpServlet {
    private ContractService contractService = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contract_start_date = request.getParameter("contract_start_date").trim();
        String contract_end_date = request.getParameter("contract_end_date").trim();
        double contract_deposit = Double.parseDouble(request.getParameter("contract_deposit"));
        double contract_total_money = Double.parseDouble(request.getParameter("contract_total_money"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Contract contract = new Contract(contract_start_date,contract_end_date,contract_deposit,
                contract_total_money, employee_id,customer_id,service_id);
        try {
            if (contractService.insertContract(contract)) {
                request.setAttribute("listContract", contractService.selectAllContract());
                request.getRequestDispatcher("jsp/contract/list.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/contract/create.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/contract/create.jsp").forward(request, response);
    }
}
