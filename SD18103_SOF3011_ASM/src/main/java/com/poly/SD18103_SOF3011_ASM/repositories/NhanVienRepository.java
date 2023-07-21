package com.poly.SD18103_SOF3011_ASM.repositories;

import com.poly.SD18103_SOF3011_ASM.entities.NhanVien;
import com.poly.SD18103_SOF3011_ASM.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class NhanVienRepository {

    public List<NhanVien> getAll() {
        List<NhanVien> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien order by ma asc");
            list = query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public NhanVien getNhanVienByMa(String ma) {
        NhanVien nhanVien = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from NhanVien where ma =: ma");
            query.setParameter("ma", ma);
            nhanVien = (NhanVien) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return nhanVien;
    }

    public boolean add(NhanVien nhanVien) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(NhanVien nhanVien) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(NhanVien nhanVien) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nhanVien);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
