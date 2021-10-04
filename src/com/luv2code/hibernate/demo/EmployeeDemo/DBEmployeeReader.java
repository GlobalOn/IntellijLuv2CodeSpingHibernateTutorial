package com.luv2code.hibernate.demo.EmployeeDemo;

import com.luv2code.hibernate.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBEmployeeReader {

    public void readEmployee(int employeeId) {
        try (SessionFactory sessionFactory = new Configuration().
                configure("hibernate-employee.cfg.xml").
                addAnnotatedClass(Employee.class).
                buildSessionFactory()) {

            Session session = sessionFactory.getCurrentSession();

            session.beginTransaction();

            Employee employee = session.get(Employee.class, employeeId);

            System.out.println(employee);

            session.getTransaction().commit();
        }
    }
}
