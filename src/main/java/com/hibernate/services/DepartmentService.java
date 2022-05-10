package com.hibernate.services;

import com.hibernate.dao.DepartmentI;
import com.hibernate.models.Department;
import com.hibernate.util.HibernateUtil;
import lombok.extern.java.Log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

@Log
public class DepartmentService implements DepartmentI {
    @Override
    public List<Department> getAllDepartments() {
        Session s = HibernateUtil.getSessionFactory().openSession();
        List<Department> d = s.createQuery("from Department", Department.class).list();
        s.close();
        return d;
    }

    @Override
    public Department createDepartment(Department d) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.persist(d);
            tx.commit();
        } catch (HibernateException ex) {
            if (tx!=null) tx.rollback();
            ex.printStackTrace();
        } finally {
            s.close();
        }
        return d;
    }

    @Override
    public boolean updateDepartment(Department d) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        String hql = "UPDATE Department set name = :name, state = :state where did = :id";
        Transaction tx = null;

        try {
            if (s.get(Department.class, d.getDid()) == null){
                throw new HibernateException("Department with DID " + d.getDid() + " Not Found!");
            }

            tx = s.beginTransaction();
            Query q = s.createQuery(hql);
            q.setParameter("name", d.getName());
            q.setParameter("state", d.getState());
            q.setParameter("did", d.getDid());

            int affected = q.executeUpdate();
            log.info("Rows affected: " + affected);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx!=null) tx.rollback();
            ex.printStackTrace();
        } finally {
            s.close();
        }
        return false;
    }

    @Override
    public boolean deleteDepartment(Department d) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;

        try {
            tx = s.beginTransaction();
            s.delete(d);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx!= null) tx.rollback();
            ex.printStackTrace();
        } finally {
            s.close();
        }
        return false;
    }

    @Override
    public Department getDepartmentById(int id) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            Department d = s.get(Department.class, id);
            if (d == null)
                throw new HibernateException("Did not find employee");
            else
                return d;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            s.close();
        }
        return new Department();
    }
}
