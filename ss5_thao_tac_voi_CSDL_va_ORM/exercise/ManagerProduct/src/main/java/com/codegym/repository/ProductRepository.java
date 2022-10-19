package com.codegym.repository;

import com.codegym.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductRepository implements IProductRepository{

    @Override
    public List<Product> findAll() {
        Session session = null;
        List<Product> productList = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product ").getResultList();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void add(Product product) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(session.find(Product.class,id));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findProductById(int id) {
        Session session = null;
        Product product;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            product = session.find(Product.class,id);
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return product;
    }

    @Override
    public void update(Product product) {
        Session session = null;
        Transaction transaction = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            if(session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Product> searchByName(String nameSearch) {
        Session session = null;
        List<Product> productList = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            productList = session.createQuery("FROM Product where name like :name")
                    .setParameter("name", "%"+nameSearch+"%").getResultList();
        } finally {
            if(session != null) {
                session.close();
            }
        }
        return productList;
    }

}
