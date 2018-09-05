package com.strangengpuppies.strangengpuppies.repository.base;


import com.strangengpuppies.strangengpuppies.model.Service;

import java.util.List;

public interface ServiceRepository {
  List<Service> getAllService();
  Service getServiceByID(int id);
  void createService(String name);
  void updateService(int id, String name);
  void deleteService(int id);

}
