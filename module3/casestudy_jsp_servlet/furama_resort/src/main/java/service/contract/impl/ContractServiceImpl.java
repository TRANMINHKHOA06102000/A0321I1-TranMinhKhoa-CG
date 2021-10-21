package service.contract.impl;

import bean.Contract;
import repository.contract.ContractRepository;
import repository.contract.impl.ContractRepositoryImp;
import service.contract.ContractService;

import java.sql.SQLException;
import java.util.List;

public class ContractServiceImpl implements ContractService {
    private ContractRepository contractRepository= new ContractRepositoryImp();
    @Override
    public List<Contract> selectAllContract() throws SQLException {
        return contractRepository.selectAllContract();
    }

    @Override
    public boolean insertContract(Contract contract) throws SQLException {
        return contractRepository.insertContract(contract);
    }
}
