package controller.contract_detail;


import bean.ContractDetail;
import service.contract_detail.ContractDetailService;
import service.contract_detail.impl.ContractDetailServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "CreateContractDetailServlet", urlPatterns = "/createContractDetail")
public class CreateContractDetailServlet extends HttpServlet {
    private ContractDetailService contractDetailService = new ContractDetailServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        int attach_service_id = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(contract_id,attach_service_id,quantity);
        try {
            if (contractDetailService.insertContractDetail(contractDetail)) {
                request.setAttribute("listContractDetail", contractDetailService.selectAllContractDetail());
                request.getRequestDispatcher("jsp/contract_detail/list.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("jsp/contract_detail/create.jsp").forward(request, response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/contract_detail/create.jsp").forward(request, response);
    }
}
