package com.poly.SD18103_SOF3011_ASM.repositories;

import com.poly.SD18103_SOF3011_ASM.entities.ChiTietSP;
import com.poly.SD18103_SOF3011_ASM.util.HibernateUtil;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamRepository {

    public List<ChiTietSP> getAll() {
        List<ChiTietSP> list = new ArrayList<>();
        String hql = "select ctsp.id, sp.ten, nsx.ten, ms.ten, dsp.ten, ctsp.namBH, ctsp.soLuongTon, ctsp.giaNhap, ctsp.giaBan, ctsp.moTa" +
                " from ChiTietSP ctsp inner join " +
                " SanPham sp on ctsp.sanPham = sp.id inner join " +
                " NSX nsx on ctsp.nsx = nsx.id inner join " +
                " MauSac ms on ctsp.mauSac = ms.id inner join " +
                " DongSP dsp on ctsp.dongSP = dsp.id";
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSP ");
            list = query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ChiTietSP getCTSPById(UUID id) {
        ChiTietSP chiTietSP = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSP where id =: id");
            query.setParameter("id", id);
            chiTietSP = (ChiTietSP) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }

    public boolean add(ChiTietSP ctsp) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.persist(ctsp);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ChiTietSP chiTietSP) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chiTietSP);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public UUID getIdSanPham(UUID id) {
        UUID idSanPham = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select ctsp.sanPham.id from ChiTietSP ctsp where id =: id");
            query.setParameter("id", id);
            idSanPham = (UUID) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return idSanPham;
    }

    public UUID getIdMauSac(UUID id) {
        UUID idMauSac = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select ctsp.mauSac.id from ChiTietSP ctsp where id =: id");
            query.setParameter("id", id);
            idMauSac = (UUID) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return idMauSac;
    }

    public UUID getIdNSX(UUID id) {
        UUID idNSX = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select ctsp.nsx.id from ChiTietSP ctsp where id =: id");
            query.setParameter("id", id);
            idNSX = (UUID) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return idNSX;
    }

    public UUID getIdDongSP(UUID id) {
        UUID idDongSP = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select ctsp.dongSP.id from ChiTietSP ctsp where id =: id");
            query.setParameter("id", id);
            idDongSP = (UUID) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return idDongSP;
    }

    public boolean delete(ChiTietSP chiTietSP) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chiTietSP);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ChiTietSP> search(String spTen, String msTen, String dspTen, String nsxTen) {
        List<ChiTietSP> list = new ArrayList<>();
        String hql = "from ChiTietSP where sanPham.ten like :spTen or mauSac.ten like :msTen or dongSP.ten like :dspTen or nsx.ten like :nsxTen";
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("spTen", "%" + spTen + "%");
            query.setParameter("msTen", "%" + msTen + "%");
            query.setParameter("dspTen", "%" + dspTen + "%");
            query.setParameter("nsxTen", "%" + nsxTen + "%");
            list = query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Integer getSoLuong(UUID idChiTietSP) {
        Integer soLuongTon = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("select ctsp.soLuongTon from ChiTietSP ctsp where id =: id");
            query.setParameter("id", idChiTietSP);
            soLuongTon = (Integer) query.getSingleResult();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return soLuongTon;
    }

    public void updateSoLuong(Integer soLuong, UUID idChiTietSP) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery("update ChiTietSP set soLuongTon =: soLuong where id =: id");
            query.setParameter("soLuong", soLuong);
            query.setParameter("id", idChiTietSP);
            query.executeUpdate();
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<ChiTietSP> getListCTSPByIdDongSP(UUID id) {
        List<ChiTietSP> list = new ArrayList<>();
        String hql = "from ChiTietSP where dongSP.id =: id";
        try(Session session = HibernateUtil.getFACTORY().openSession()) {
            Query query = session.createQuery(hql);
            query.setParameter("id", id);
            list = query.getResultList();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
