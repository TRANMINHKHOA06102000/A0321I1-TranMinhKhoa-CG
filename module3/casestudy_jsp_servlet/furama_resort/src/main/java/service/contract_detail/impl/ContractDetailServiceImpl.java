package service.contract_detail.impl;

import bean.ContractDetail;
import repository.contract_detail.ContractDetailRepository;
import repository.contract_detail.impl.ContractDetailRepositoryImpl;
import service.contract_detail.ContractDetailService;

import java.sql.SQLException;
import java.util.List;

public class ContractDetailServiceImpl implements ContractDetailService {
    private ContractDetailRepository contractDetailRepository= new ContractDetailRepositoryImpl();
    @Override
    public List<ContractDetail> selectAllContractDetail() throws SQLException {
        return contractDetailRepository.selectAllContractDetail();
    }

    @Override
    public boolean insertContractDetail(ContractDetail contractDetail) throws SQLException {
        return contractDetailRepository.insertContractDetail(contractDetail);
    }
}
