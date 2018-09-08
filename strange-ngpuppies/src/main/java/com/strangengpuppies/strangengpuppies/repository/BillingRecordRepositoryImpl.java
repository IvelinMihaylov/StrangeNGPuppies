package com.strangengpuppies.strangengpuppies.repository;

import com.strangengpuppies.strangengpuppies.model.Bill;
import com.strangengpuppies.strangengpuppies.model.Service;
import com.strangengpuppies.strangengpuppies.model.Subscriber;
import com.strangengpuppies.strangengpuppies.repository.base.BillingRecordRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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
  public List<Bill> getReadyBills() {
    List<Bill> bills = new ArrayList<>();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 bills = session.createQuery("from Bill WHERE status = 'approved' or status = 'refused'", Bill.class).list();
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
    return bills;
  }
  
  @Override
  public List<Bill> getNonReadyBills() {
    List<Bill> bills = new ArrayList<>();
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 bills = session.createQuery("from Bill where status = 'waiting'", Bill.class).list();
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
	 bill = session.get(Bill.class, id);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
    return bill;
  }
  
  @Override
  public void createBill(Service service, Subscriber subscriber, LocalDate startDate, LocalDate endDate, double amount, String currency) {
    Bill bill = new Bill(service, subscriber, startDate, endDate, amount, currency);
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.save(bill);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
  
  @Override
  public void updateBills(List<Bill> bills) {
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 for(Bill bill : bills) {
	   session.update(bill);
	 }
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
  
  @Override
  public void updateBill(Bill bill) {
    try (Session session = factory.openSession()) {
	 session.beginTransaction();
	 session.update(bill);
	 session.getTransaction().commit();
    } catch (Exception ex) {
	 System.out.println(ex.getMessage());
    }
  }
  
}
