package com.strangengpuppies.strangengpuppies.service;

import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.repository.base.ServiceRepository;
import com.strangengpuppies.strangengpuppies.service.base.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@org.springframework.stereotype.Service
public class ServicesServiceImpl implements ServicesService {
  
  private final ServiceRepository serviceRepository;
  
  @Autowired
  public ServicesServiceImpl(ServiceRepository serviceRepository) {
    this.serviceRepository = serviceRepository;
  }
  
  @Override
  public List<Service> getAllService() {
    return serviceRepository.getAll();
  }
  
  @Override
  public com.strangengpuppies.strangengpuppies.model.Service getServiceByID(int id) {
    return serviceRepository.getById(id);
  }

  @Override
  public void createService(String name) {
    serviceRepository.createService(name);
  }

  @Override
  public void updateService(int id, String name) {
    serviceRepository.updateService(id, name);
  }

  @Override
  public void deleteService(int id) {
    serviceRepository.deleteService(id);
  }
}
