package com.strangengpuppies.strangengpuppies.web.RestControllers;

import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.service.base.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("api/service")
public class ServicesRestController {
  
  private final ServicesService service;
  
  @Autowired
  public ServicesRestController(ServicesService service) {
    this.service = service;
  }
  
  @GetMapping ("/listAll")
  public List<Service> getAll() {
    return service.getAllService();
  }
  
  @GetMapping ("/byID/{id}")
  public Service getByID(@PathVariable ("id") String id) {
    return service.getServiceByID(Integer.parseInt(id));
  }
  
  @PostMapping (value = "/update/{id}{name}", headers = "Accept=application/json")
  public void updateServiceById(@PathVariable ("id") String id, @PathVariable ("name") String name) {
    service.updateService(Integer.parseInt(id), name);
  }
  
  @PostMapping (value = "/create/{name}", headers = "Accept=application/json")
  public void createSubscriber(String name) {
    service.createService(name);
  }
  
  @PostMapping (value = "/delete/{id}", headers = "Accept=application/json")
  public void deleteSubscriber(@PathVariable ("id") String id) {
    service.deleteService(Integer.parseInt(id));
  }
}
