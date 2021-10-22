package repository.contract_detail.impl;

import bean.Contract;
import bean.ContractDetail;
import repository.BaseRepository;
import repository.contract_detail.ContractDetailRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContractDetailRepositoryImpl implements ContractDetailRepository {
    private static final String SELECT_ALL_CONTRACT_DETAIL = "select contract_detail.* from contract_detail " +
            "left join contract on contract.contract_id=contract_detail.contract_id " +
            "left join attach_service on attach_service.attach_service_id=contract_detail.attach_service_id;";
    private static final String INSERT_CONTRACT_DETAIL_SQL = "insert into contract_detail(contract_id," +
            "attach_service_id,quantity) values (?,?,?)";
    BaseRepository baseRepository= new BaseRepository();
    @Override
    public List<ContractDetail> selectAllContractDetail() throws SQLException {
        List<ContractDetail> contractDetailList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT_DETAIL);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int contract_detail_id = resultSet.getInt("contract_detail_id");
            int contract_id = resultSet.getInt("contract_id");
            int attach_service_id = resultSet.getInt("attach_service_id");
            int quantity = resultSet.getInt("quantity");
            contractDetailList.add(new ContractDetail(contract_detail_id,contract_id,attach_service_id,quantity));
        }
        return contractDetailList;
    }

    @Override
    public boolean insertContractDetail(ContractDetail contractDetail) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_CONTRACT_DETAIL_SQL);
        preparedStatement.setInt(1, contractDetail.getContract_id());
        preparedStatement.setInt(2, contractDetail.getAttach_service_id());
        preparedStatement.setInt(3, contractDetail.getQuantity());
        row = preparedStatement.executeUpdate();
        return row > 0;
    }
}
