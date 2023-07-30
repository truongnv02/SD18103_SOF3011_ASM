package com.poly.SD18103_SOF3011_ASM.repositories;

import com.poly.SD18103_SOF3011_ASM.entities.NhanVien;
import com.poly.SD18103_SOF3011_ASM.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public boolean update(String ma, NhanVien nhanVien) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery("update NhanVien set ten =: ten, tenDem =: tenDem, ho =: ho," +
                    " gioiTinh =: gioiTinh, ngaySinh =: ngaySinh, diaChi =: diaChi, sdt =: sdt, cuaHang.id =: idCuaHang, " +
                    " chucVu.id =: idChucVu, trangThai =: trangThai, matKhau =: matKhau where ma =: ma");
            query.setParameter("ten", nhanVien.getTen());
            query.setParameter("tenDem", nhanVien.getTenDem());
            query.setParameter("ho", nhanVien.getHo());
            query.setParameter("gioiTinh", nhanVien.getGioiTinh());
            query.setParameter("ngaySinh", nhanVien.getNgaySinh());
            query.setParameter("diaChi", nhanVien.getDiaChi());
            query.setParameter("sdt", nhanVien.getSdt());
            query.setParameter("idCuaHang", nhanVien.getCuaHang().getId());
            query.setParameter("idChucVu", nhanVien.getChucVu().getId());
            query.setParameter("trangThai", nhanVien.getTrangThai());
            query.setParameter("matKhau", nhanVien.getMatKhau());
            query.setParameter("ma", ma);
            query.executeUpdate();
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public UUID getIdChucVuByMa(String ma) {
        UUID idChucVu = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select nv.chucVu.id from NhanVien nv where ma =: ma");
            query.setParameter("ma", ma);
            idChucVu = (UUID) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return idChucVu;
    }

    public UUID getIdCuaHangByMa(String ma) {
        UUID idCuaHang = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select nv.cuaHang.id from NhanVien nv where ma =: ma");
            query.setParameter("ma", ma);
            idCuaHang = (UUID) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return idCuaHang;
    }
}