package com.strangengpuppies.strangengpuppies.repository;

import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.repository.base.ServiceRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServiceRepositoryImpl implements ServiceRepository {
    private static SessionFactory factory;

    @Autowired
    public ServiceRepositoryImpl (SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public Service getById(int id) {
        Service service = new Service();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            service = session.get(Service.class, id);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return service;
    }

    @Override
    public List<Service> getAll() {
        List<Service> serviceList = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            serviceList = session.createQuery("from Service ", Service.class).list();
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return serviceList;
    }
}
