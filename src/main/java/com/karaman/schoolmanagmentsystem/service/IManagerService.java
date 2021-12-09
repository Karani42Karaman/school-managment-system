package com.karaman.schoolmanagmentsystem.service;

import com.karaman.schoolmanagmentsystem.model.ManagerModel;

import java.util.List;

public interface IManagerService {
    List<ManagerModel> getAllManager();
    ManagerModel saveManager(ManagerModel  managerModel);
    ManagerModel getManagerById(Long id);
    ManagerModel updateManager(ManagerModel managerModelanager);
    void deleteManagerById(Long id);
}
