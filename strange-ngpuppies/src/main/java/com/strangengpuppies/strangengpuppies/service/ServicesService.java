package com.strangengpuppies.strangengpuppies.service;

import com.strangengpuppies.strangengpuppies.repository.base.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {
    private final ServiceRepository serviceRepository;

    @Autowired
    public ServicesService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public List<com.strangengpuppies.strangengpuppies.model.Service> listAll(){
        return serviceRepository.getAll();
    }

    public com.strangengpuppies.strangengpuppies.model.Service getById(int id) {
        return serviceRepository.getById(id);
    }
}
