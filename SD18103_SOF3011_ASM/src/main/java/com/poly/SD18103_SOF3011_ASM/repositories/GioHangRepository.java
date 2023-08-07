package com.poly.SD18103_SOF3011_ASM.repositories;

import com.poly.SD18103_SOF3011_ASM.entities.GioHang;
import com.poly.SD18103_SOF3011_ASM.entities.GioHangChiTiet;
import com.poly.SD18103_SOF3011_ASM.entities.NhanVien;
import com.poly.SD18103_SOF3011_ASM.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GioHangRepository {

    public List<GioHangChiTiet> getAllGioHangChiTiet() {
        List<GioHangChiTiet> list = new ArrayList<>();
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from GioHangChiTiet ");
            list = query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public GioHang getGioHang(UUID idKhachHang) {
        GioHang gioHang = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from GioHang  where khachHang.id =: idKhachHang and tinhTrang =: tinhTrang");
            query.setParameter("idKhachHang", idKhachHang);
            query.setParameter("tinhTrang", 0);
            if(query.getResultList().isEmpty()) {
                return null;
            }else {
                gioHang = (GioHang) query.getSingleResult();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
        return gioHang;
    }

    public boolean addGioHang(GioHang gioHang) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(gioHang);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addGioHangChiTiet(GioHangChiTiet gioHangChiTiet) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {

            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        }
        return false;
    }

    public boolean deleteAll(UUID idGioHang) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from GioHangChiTiet where id =: id");
            query.setParameter("id", idGioHang);
            query.executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(UUID idGioHang, UUID idSanPham) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("delete GioHangChiTiet where id =: idGIoHang and chiTietSP.id =: idSanPham");
            query.setParameter("idGioHang", idGioHang);
            query.setParameter("idSanPham", idSanPham);
            query.executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
