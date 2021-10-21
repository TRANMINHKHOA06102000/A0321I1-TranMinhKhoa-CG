package repository.contract;

import bean.Contract;

import java.sql.SQLException;
import java.util.List;

public interface ContractRepository {
    List<Contract> selectAllContract() throws SQLException;

    boolean insertContract(Contract contract) throws SQLException;
}
