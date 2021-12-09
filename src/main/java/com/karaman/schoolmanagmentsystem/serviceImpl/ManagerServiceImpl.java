package com.karaman.schoolmanagmentsystem.serviceImpl;

import com.karaman.schoolmanagmentsystem.model.ManagerModel;
import com.karaman.schoolmanagmentsystem.repository.IManagerRepository;
import com.karaman.schoolmanagmentsystem.service.IManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements IManagerService {

    @Autowired
    public IManagerRepository managerRepository;

    public ManagerServiceImpl(IManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }


    @Override
    public List<ManagerModel> getAllManager() {
        return managerRepository.findAll();
    }

    @Override
    public ManagerModel saveManager(ManagerModel managerModel) {
        return managerRepository.save(managerModel);
    }

    @Override
    public ManagerModel getManagerById(Long id) {
        return managerRepository.getById(id);
    }

    @Override
    public ManagerModel updateManager(ManagerModel managerModelanager) {
        return managerRepository.save(managerModelanager);
    }

    @Override
    public void deleteManagerById(Long id) {
        managerRepository.deleteById(id);
    }
}
