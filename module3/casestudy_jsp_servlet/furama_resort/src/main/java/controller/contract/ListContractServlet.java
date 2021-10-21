package controller.contract;

import bean.Contract;
import service.contract.ContractService;
import service.contract.impl.ContractServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListContractServlet", urlPatterns = "/contracts")
public class ListContractServlet extends HttpServlet {
    private ContractService contractService = new ContractServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Contract> contracts = null;
        try {
            contracts = this.contractService.selectAllContract();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listContract", contracts);
        request.getRequestDispatcher("jsp/contract/list.jsp").forward(request, response);
    }
}
