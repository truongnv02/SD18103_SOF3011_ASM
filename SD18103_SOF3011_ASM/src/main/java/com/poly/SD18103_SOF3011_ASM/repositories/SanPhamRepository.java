package com.poly.SD18103_SOF3011_ASM.repositories;

import com.poly.SD18103_SOF3011_ASM.entities.SanPham;
import com.poly.SD18103_SOF3011_ASM.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class SanPhamRepository {

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPham order by ma asc");
            list = query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public SanPham getSanPhamByMa(String ma) {
        SanPham sanPham = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from SanPham where ma =: ma");
            query.setParameter("ma", ma);
            sanPham = (SanPham) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sanPham;
    }

    public boolean add(SanPham sanPham) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(String ma, SanPham sanPham) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update SanPham set ten =: ten where ma =: ma");
            query.setParameter("ten", sanPham.getTen());
            query.setParameter("ma", ma);
            query.executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(SanPham sanPham) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
