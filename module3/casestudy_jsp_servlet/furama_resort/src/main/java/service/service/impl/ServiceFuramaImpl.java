package service.service.impl;

import bean.Service;
import repository.service.ServiceRepository;
import repository.service.impl.ServiceRepositoryImpl;
import service.service.ServiceFurama;

import java.sql.SQLException;
import java.util.List;

public class ServiceFuramaImpl implements ServiceFurama {
    private ServiceRepository serviceRepository= new ServiceRepositoryImpl();
    @Override
    public List<Service> selectAllService() throws SQLException {
        return serviceRepository.selectAllService();
    }

    @Override
    public boolean insertService(Service service) throws SQLException {
        return serviceRepository.insertService(service);
    }
}
