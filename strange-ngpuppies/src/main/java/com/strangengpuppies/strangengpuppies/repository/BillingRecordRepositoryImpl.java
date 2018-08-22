package com.strangengpuppies.strangengpuppies.repository;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.repository.base.BillingRecordRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class BillingRecordRepositoryImpl implements BillingRecordRepository {
  private static SessionFactory factory;
  
  @Autowired
  public BillingRecordRepositoryImpl(SessionFactory factory) {
    this.factory = factory;
  }
  
  @Override
  public List<Bill> getAllBills() {
    List<Bill> bills = new ArrayList<>();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 bills = session.createQuery("from Bill", Bill.class).list();
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
    return bills;
  }
  
  @Override
  public Bill getBillById(int id) {
    Bill bill = new Bill();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 bill = session.get(Bill.class,id);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
    return bill;
  }
}
