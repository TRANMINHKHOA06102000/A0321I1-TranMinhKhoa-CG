package repository.contract.impl;

import bean.Contract;
import bean.Customer;
import repository.BaseRepository;
import repository.contract.ContractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractRepositoryImp implements ContractRepository {
    private static final String SELECT_ALL_CONTRACT = "select contract.* from contract " +
            "left join employee on employee.employee_id=contract.employee_id " +
            "left join customer on customer.customer_id=contract.customer_id " +
            "left join service on service.service_id=contract.service_id;";
    private static final String INSERT_CONTRACT_SQL = "insert into contract(contract_start_date,contract_end_date," +
            "contract_deposit,contract_total_money,employee_id,customer_id,service_id) " +
            "values (?,?,?,?,?,?,?)";
    BaseRepository baseRepository= new BaseRepository();
    @Override
    public List<Contract> selectAllContract() throws SQLException {
        List<Contract> contractList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int contract_id = resultSet.getInt("contract_id");
            String contract_start_date = resultSet.getString("contract_start_date");
            String contract_end_date = resultSet.getString("contract_end_date");
            double contract_deposit = resultSet.getDouble("contract_deposit");
            double contract_total_money = resultSet.getDouble("contract_total_money");
            int employee_id = resultSet.getInt("employee_id");
            int customer_id = resultSet.getInt("customer_id");
            int service_id = resultSet.getInt("service_id");
            contractList.add(new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit,
                    contract_total_money, employee_id, customer_id, service_id));
        }
        return contractList;
    }

    @Override
    public boolean insertContract(Contract contract) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_CONTRACT_SQL);
        preparedStatement.setString(1, contract.getContract_start_date());
        preparedStatement.setString(2, contract.getContract_end_date());
        preparedStatement.setDouble(3, contract.getContract_deposit());
        preparedStatement.setDouble(4, contract.getContract_total_money());
        preparedStatement.setInt(5, contract.getEmployee_id());
        preparedStatement.setInt(6, contract.getCustomer_id());
        preparedStatement.setInt(7, contract.getService_id());
        row = preparedStatement.executeUpdate();
        return row > 0;
    }
}
