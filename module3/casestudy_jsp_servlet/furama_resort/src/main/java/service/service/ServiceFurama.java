package service.service;

import bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface ServiceFurama {
    List<Service> selectAllService() throws SQLException;
    boolean insertService(Service service) throws SQLException;
}
