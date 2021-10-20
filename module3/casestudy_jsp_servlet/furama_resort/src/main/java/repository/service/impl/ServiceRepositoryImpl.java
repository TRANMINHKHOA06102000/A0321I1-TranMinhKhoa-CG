package repository.service.impl;

import bean.Service;
import repository.BaseRepository;
import repository.service.ServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements ServiceRepository {
    private static final String SELECT_ALL_SERVICE = "select service.* from service " +
            "left join service_type on service_type.service_type_id = service.service_type_id " +
            "left join rent_type on rent_type.rent_type_id = service.rent_type_id;";
    private static final String INSERT_SERVICE = "insert into service(service_name,service_area,service_cost," +
            "service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience," +
            "pool_area,number_of_floors) values (?,?,?,?,?,?,?,?,?,?);";
    private BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Service> selectAllService() throws SQLException {
        List<Service> serviceList = new ArrayList<>();
        Connection connection = this.baseRepository.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int service_id = resultSet.getInt("service_id");
            String service_name = resultSet.getString("service_name");
            int service_area = resultSet.getInt("service_area");
            double service_cost = resultSet.getDouble("service_cost");
            int service_max_people = resultSet.getInt("service_max_people");
            int rent_type_id = resultSet.getInt("rent_type_id");
            int service_type_id = resultSet.getInt("service_type_id");
            String standard_room = resultSet.getString("standard_room");
            String description_other_convenience = resultSet.getString("description_other_convenience");
            double pool_area = resultSet.getDouble("pool_area");
            int number_of_floors = resultSet.getInt("number_of_floors");
            serviceList.add(new Service(service_id, service_name, service_area, service_cost,
                    service_max_people, rent_type_id, service_type_id, standard_room,
                    description_other_convenience, pool_area, number_of_floors));
        }
        return serviceList;
    }

    @Override
    public boolean insertService(Service service) throws SQLException {
        int row = 0;
        PreparedStatement preparedStatement = this.baseRepository.getConnection().prepareStatement(INSERT_SERVICE);
        preparedStatement.setString(1, service.getService_name());
        preparedStatement.setInt(2, service.getService_area());
        preparedStatement.setDouble(3, service.getService_cost());
        preparedStatement.setInt(4, service.getService_max_people());
        preparedStatement.setInt(5, service.getRent_type_id());
        preparedStatement.setInt(6, service.getService_type_id());
        preparedStatement.setString(7, service.getStandard_room());
        preparedStatement.setString(8, service.getDescription_other_convenience());
        preparedStatement.setDouble(9, service.getPool_area());
        preparedStatement.setInt(10, service.getNumber_of_floors());
        row = preparedStatement.executeUpdate();
        return row > 0;
    }
}
