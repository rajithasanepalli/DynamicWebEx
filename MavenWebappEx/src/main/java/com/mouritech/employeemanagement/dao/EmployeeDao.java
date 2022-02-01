package com.mouritech.employeemanagement.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mouritech.employeemanagement.entity.Employee;
import com.mouritech.employeemanagement.util.HibernateUtil;
public class EmployeeDao {
	public List<Employee> getAllEmployees() {
		Transaction transaction = null;
		List<Employee> empList = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			
			
			//get entity from database
			empList = session.createQuery("from Employee").getResultList();
	
			//commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return empList;
	}

	public void saveEmployee(Employee emp) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			// save the employee object in to database
			session.save(emp);
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
	}

	public void deleteEmployee(Integer empid) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
			//find the employee object from the database
			Employee emp = session.get(Employee.class, empid);
			if(emp != null) {
			// delete the employee object in to database
			session.delete(emp);
			System.out.println("Employee deleted");
			}
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public void updateEmployee(Employee emp) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();

			session.saveOrUpdate(emp);
	
			// commit transaction
			transaction.commit();
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		
	}

	public Employee getEmployee(Integer empid) {
		Transaction transaction = null;
		Employee empById = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			// start the transaction
			transaction = session.beginTransaction();
		
			
			//get entity from database using employee id
			empById = session.get(Employee.class, empid);
			if(empById!=null) {
				
				System.out.println("Employee details are = " + empById);
			}
		}catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}

			e.printStackTrace();
		}
		return empById;
	}



}
