package controller.contract_detail;

import bean.Contract;
import bean.ContractDetail;
import service.contract.ContractService;
import service.contract.impl.ContractServiceImpl;
import service.contract_detail.ContractDetailService;
import service.contract_detail.impl.ContractDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListContractDetailServlet", urlPatterns = "/contractDetail")
public class ListContractDetailServlet extends HttpServlet {
    private ContractDetailService contractDetailService =new ContractDetailServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ContractDetail> contractDetails = null;
        try {
            contractDetails = this.contractDetailService.selectAllContractDetail();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("listContractDetail", contractDetails);
        request.getRequestDispatcher("jsp/contract_detail/list.jsp").forward(request, response);
    }
}
