package com.poly.SD18103_SOF3011_ASM.repositories;

import com.poly.SD18103_SOF3011_ASM.entities.MauSac;
import com.poly.SD18103_SOF3011_ASM.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class MauSacRepository {

    public List<MauSac> getAll() {
        List<MauSac> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from MauSac order by ma asc");
            list = query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public MauSac getMauSacByMa(String ma) {
        MauSac mauSac = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from MauSac where ma =: ma");
            query.setParameter("ma", ma);
            mauSac = (MauSac) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }

    public boolean add(MauSac mauSac) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(MauSac mauSac) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(mauSac);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String ma, MauSac mauSac) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update MauSac set ten =: ten where ma =: ma");
            query.setParameter("ten", mauSac.getTen());
            query.setParameter("ma", ma);
            query.executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
