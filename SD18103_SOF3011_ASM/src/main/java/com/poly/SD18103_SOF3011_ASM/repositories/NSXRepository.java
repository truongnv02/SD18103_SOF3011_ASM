package com.poly.SD18103_SOF3011_ASM.repositories;

import com.poly.SD18103_SOF3011_ASM.entities.NSX;
import com.poly.SD18103_SOF3011_ASM.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class NSXRepository {

    public List<NSX> getAll() {
        List<NSX> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NSX order by ma asc");
            list = query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NSX getNSXByMa(String ma) {
        NSX nsx = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NSX where ma =: ma");
            query.setParameter("ma", ma);
            nsx = (NSX) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }

    public boolean add(NSX nsx) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nsx);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String ma, NSX nsx) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update NSX set ten =: ten where ma =: ma");
            query.setParameter("ten", nsx.getTen());
            query.setParameter("ma", ma);
            query.executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(NSX nsx) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
