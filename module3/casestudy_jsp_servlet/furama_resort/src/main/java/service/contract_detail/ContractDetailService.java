package service.contract_detail;

import bean.ContractDetail;

import java.sql.SQLException;
import java.util.List;

public interface ContractDetailService {
    List<ContractDetail> selectAllContractDetail() throws SQLException;

    boolean insertContractDetail(ContractDetail contractDetail) throws SQLException;
}
