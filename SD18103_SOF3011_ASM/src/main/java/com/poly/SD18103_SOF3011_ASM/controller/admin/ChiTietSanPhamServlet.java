package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.ChiTietSP;
import com.poly.SD18103_SOF3011_ASM.entities.DongSP;
import com.poly.SD18103_SOF3011_ASM.entities.MauSac;
import com.poly.SD18103_SOF3011_ASM.entities.NSX;
import com.poly.SD18103_SOF3011_ASM.entities.SanPham;
import com.poly.SD18103_SOF3011_ASM.repositories.ChiTietSanPhamRepository;
import com.poly.SD18103_SOF3011_ASM.repositories.DongSPRepository;
import com.poly.SD18103_SOF3011_ASM.repositories.MauSacRepository;
import com.poly.SD18103_SOF3011_ASM.repositories.NSXRepository;
import com.poly.SD18103_SOF3011_ASM.repositories.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "ChiTietSanPham", value = {
        "/chi-tiet-san-pham/hien-thi",
        "/chi-tiet-san-pham/view-add",
        "/chi-tiet-san-pham/add",
        "/chi-tiet-san-pham/detail",
        "/chi-tiet-san-pham/update",
        "/chi-tiet-san-pham/delete"
})
public class ChiTietSanPhamServlet extends HttpServlet {
    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    private NSXRepository nsxRepository = new NSXRepository();
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            this.hienThi(req, resp);
        }else if(uri.contains("view-add")) {
            this.viewAdd(req, resp);
        }else if(uri.contains("delete")) {
            this.delete(req, resp);
        }else if(uri.contains("detail")) {
            this.detail(req, resp);
        }else {
            this.hienThi(req, resp);
        }
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // lay ra danh sach doi tuong
        List<SanPham> listSanPham = sanPhamRepository.getAll();
        req.setAttribute("listSanPham", listSanPham);
        List<NSX> listNSX = nsxRepository.getAll();
        req.setAttribute("listNSX", listNSX);
        List<MauSac> listMauSac = mauSacRepository.getAll();
        req.setAttribute("listMauSac", listMauSac);
        List<DongSP> listDongSP = dongSPRepository.getAll();
        req.setAttribute("listDongSP", listDongSP);
        // lay id tu url
        UUID id = UUID.fromString(req.getParameter("id"));
        req.setAttribute("idSanPham", chiTietSanPhamRepository.getIdSanPham(id));
        req.setAttribute("idMauSac", chiTietSanPhamRepository.getIdMauSac(id));
        req.setAttribute("idNSX", chiTietSanPhamRepository.getIdNSX(id));
        req.setAttribute("idDongSP", chiTietSanPhamRepository.getIdDongSP(id));
        ChiTietSP chiTietSP = chiTietSanPhamRepository.getCTSPById(id);
        req.setAttribute("chiTietSP", chiTietSP);
        req.getRequestDispatcher("/views/admin/chitietsanpham/detail-ctsp.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        ChiTietSP chiTietSP = chiTietSanPhamRepository.getCTSPById(id);
        chiTietSanPhamRepository.delete(chiTietSP);
        resp.sendRedirect("/chi-tiet-san-pham/hien-thi");
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SanPham> listSanPham = sanPhamRepository.getAll();
        req.setAttribute("listSanPham", listSanPham);
        List<NSX> listNSX = nsxRepository.getAll();
        req.setAttribute("listNSX", listNSX);
        List<MauSac> listMauSac = mauSacRepository.getAll();
        req.setAttribute("listMauSac", listMauSac);
        List<DongSP> listDongSP = dongSPRepository.getAll();
        req.setAttribute("listDongSP", listDongSP);
        req.getRequestDispatcher("/views/admin/chitietsanpham/add-ctsp.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ChiTietSP> listCTSP = chiTietSanPhamRepository.getAll();
        req.setAttribute("listCTSP", listCTSP);
        req.getRequestDispatcher("/views/admin/chitietsanpham/chi-tiet-san-pham.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            this.add(req, resp);
        }else if(uri.contains("update")) {
            this.update(req, resp);
        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int namBH = Integer.parseInt(req.getParameter("namBH"));
            int soLuongTon = Integer.parseInt(req.getParameter("soLuongTon"));
            BigDecimal giaNhap = new BigDecimal(req.getParameter("giaNhap"));
            BigDecimal giaBan = new BigDecimal(req.getParameter("giaBan"));
            //lay gia id tu form
            UUID id = UUID.fromString(req.getParameter("id"));
            UUID idSanPham = UUID.fromString(req.getParameter("idSanPham"));
            UUID idNSX = UUID.fromString(req.getParameter("idNSX"));
            UUID idMauSac = UUID.fromString(req.getParameter("idMauSac"));
            UUID idDongSP = UUID.fromString(req.getParameter("idDongSP"));
            // Tao doi tuong
            SanPham sanPham = new SanPham();
            sanPham.setId(idSanPham);
            NSX nsx = new NSX();
            nsx.setId(idNSX);
            MauSac mauSac = new MauSac();
            mauSac.setId(idMauSac);
            DongSP dongSP = new DongSP();
            dongSP.setId(idDongSP);
            // set cac id vao doi tuong
            ChiTietSP chiTietSP = chiTietSanPhamRepository.getCTSPById(id);
            chiTietSP.setSanPham(sanPham);
            chiTietSP.setNsx(nsx);
            chiTietSP.setMauSac(mauSac);
            chiTietSP.setDongSP(dongSP);
            chiTietSP.setNamBH(namBH);
            chiTietSP.setSoLuongTon(soLuongTon);
            chiTietSP.setGiaNhap(giaNhap);
            chiTietSP.setGiaBan(giaBan);
            // update
            BeanUtils.populate(chiTietSP, req.getParameterMap());
            if(chiTietSanPhamRepository.add(chiTietSP)) {
                req.getSession().setAttribute("mess", "Cập nhật thành công");
                resp.sendRedirect("/chi-tiet-san-pham/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Cập nhật thất bại");
                resp.sendRedirect("/chi-tiet-san-pham/detail?id=" + id);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int namBH = Integer.parseInt(req.getParameter("namBH"));
            int soLuongTon = Integer.parseInt(req.getParameter("soLuongTon"));
            BigDecimal giaNhap = new BigDecimal(req.getParameter("giaNhap"));
            BigDecimal giaBan = new BigDecimal(req.getParameter("giaBan"));
            //lay gia id tu form
            UUID idSanPham = UUID.fromString(req.getParameter("idSanPham"));
            UUID idNSX = UUID.fromString(req.getParameter("idNSX"));
            UUID idMauSac = UUID.fromString(req.getParameter("idMauSac"));
            UUID idDongSP = UUID.fromString(req.getParameter("idDongSP"));
            // Tao doi tuong
            SanPham sanPham = new SanPham();
            sanPham.setId(idSanPham);
            NSX nsx = new NSX();
            nsx.setId(idNSX);
            MauSac mauSac = new MauSac();
            mauSac.setId(idMauSac);
            DongSP dongSP = new DongSP();
            dongSP.setId(idDongSP);
            // set cac id vao doi tuong
            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.setSanPham(sanPham);
            chiTietSP.setNsx(nsx);
            chiTietSP.setMauSac(mauSac);
            chiTietSP.setDongSP(dongSP);
            // add
            BeanUtils.populate(chiTietSP, req.getParameterMap());
            if(chiTietSanPhamRepository.add(chiTietSP)) {
                req.getSession().setAttribute("mess", "Thêm thành công");
                resp.sendRedirect("/chi-tiet-san-pham/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Thêm thất bại");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
