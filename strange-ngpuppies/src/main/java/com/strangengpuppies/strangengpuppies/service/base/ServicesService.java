package com.strangengpuppies.strangengpuppies.service.base;

import com.strangengpuppies.strangengpuppies.model.Service;

import java.util.List;

public interface ServicesService {
  List<Service> getAllService();
  
  Service getServiceByID(int id);

  void createService(String name);

  void updateService(int id, String name);

  void deleteService(int id);

}
