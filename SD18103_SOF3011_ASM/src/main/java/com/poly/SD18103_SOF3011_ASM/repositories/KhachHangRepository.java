package com.poly.SD18103_SOF3011_ASM.repositories;

import com.poly.SD18103_SOF3011_ASM.entities.KhachHang;
import com.poly.SD18103_SOF3011_ASM.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class KhachHangRepository {

    public List<KhachHang> getAll() {
        List<KhachHang> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from KhachHang order by ma asc");
            list = query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public KhachHang getKhachHangByMa(String ma) {
        KhachHang khachHang = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from KhachHang where ma =: ma");
            query.setParameter("ma", ma);
            khachHang = (KhachHang) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }

    public boolean add(KhachHang khachHang) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(khachHang);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(KhachHang khachHang) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(KhachHang khachHang) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
