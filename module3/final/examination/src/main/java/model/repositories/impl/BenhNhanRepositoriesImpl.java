package model.repositories.impl;

import model.bean.BenhNhan;
import model.repositories.BenhNhanRepositories;
import model.repositories.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepositoriesImpl implements BenhNhanRepositories {
    private static final String SELECT_ALL_SQL = "SELECT * FROM benh_nhan;";

    @Override
    public List<BenhNhan> findAll() {
        Connection connection = DBConnection.getConnection();
        List<BenhNhan> list = new ArrayList<>();
        if (connection != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SQL);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int ma_benh_nhan = resultSet.getInt("ma_benh_nhan");
                    String ten_benh_nhan = resultSet.getString("ten_benh_nhan");
                    list.add(new BenhNhan(ma_benh_nhan, ten_benh_nhan));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return list;
    }
}
