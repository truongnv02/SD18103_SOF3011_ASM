package com.poly.SD18103_SOF3011_ASM.controller.user;

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

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "HomeServlet", value = {
        "/ban-hang/trang-chu",
        "/ban-hang/search",
        "/ban-hang/detail",
        "/ban-hang/san-pham"
})
public class HomeServlet extends HttpServlet {
    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();
    private DongSPRepository dongSPRepository = new DongSPRepository();
    private NSXRepository nsxRepository = new NSXRepository();
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("trang-chu")) {
            this.trangChu(req, resp);
        } else if(uri.contains("detail")) {
            this.detailSanPham(req, resp);
        } else if(uri.contains("san-pham")) {
            this.sanPham(req, resp);
        } else if(uri.contains("search")) {
            this.search(req, resp);
        } else {
            this.trangChu(req, resp);
        }
    }

    private void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String txtSearch = req.getParameter("txtSearch");
        List<ChiTietSP> listCTSPSearch = chiTietSanPhamRepository.search(txtSearch, txtSearch, txtSearch, txtSearch);
        List<MauSac> listMauSac = mauSacRepository.getAll();
        List<NSX> listNSX = nsxRepository.getAll();
        List<DongSP> listDongSP = dongSPRepository.getAll();
        // hien thi hinh anh
        for(ChiTietSP ctsp : listCTSPSearch) {
            String fileName = ctsp.getSanPham().getImage();
            if(fileName != null) {
                ctsp.getSanPham().setImage(req.getContextPath() + "/images/" + fileName);
            }
        }
        req.setAttribute("txtValue", txtSearch);
        req.setAttribute("listCTSP", listCTSPSearch);
        req.setAttribute("listMauSac", listMauSac);
        req.setAttribute("listNSX", listNSX);
        req.setAttribute("listDongSP", listDongSP);
        req.getRequestDispatcher("/views/user/sanpham/san-pham.jsp").forward(req, resp);
    }

    private void sanPham(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ChiTietSP> listCTSP = chiTietSanPhamRepository.getAll();
        List<MauSac> listMauSac = mauSacRepository.getAll();
        List<NSX> listNSX = nsxRepository.getAll();
        List<DongSP> listDongSP = dongSPRepository.getAll();
        String realPath = req.getServletContext().getRealPath("/images");
        // hien thi hinh anh
        for(ChiTietSP ctsp : listCTSP) {
            String fileName = ctsp.getSanPham().getImage();
            if(fileName != null) {
                ctsp.getSanPham().setImage(req.getContextPath() + "/images/" + fileName);
            }
        }
        req.setAttribute("listCTSP", listCTSP);
        req.setAttribute("listMauSac", listMauSac);
        req.setAttribute("listNSX", listNSX);
        req.setAttribute("listDongSP", listDongSP);
        req.getRequestDispatcher("/views/user/sanpham/san-pham.jsp").forward(req, resp);
    }

    private void detailSanPham(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UUID id = UUID.fromString(req.getParameter("id"));
        ChiTietSP chiTietSP = chiTietSanPhamRepository.getCTSPById(id);
        req.setAttribute("detailSanPham", chiTietSP);
        req.getRequestDispatcher("/views/user/sanpham/detail-san-pham.jsp").forward(req, resp);
    }

    private void trangChu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ChiTietSP> listCTSP = chiTietSanPhamRepository.getAll();
        String realPath = req.getServletContext().getRealPath("/images");
        // hien thi hinh anh
        for(ChiTietSP ctsp : listCTSP) {
            String fileName = ctsp.getSanPham().getImage();
            if(fileName != null) {
                ctsp.getSanPham().setImage(req.getContextPath() + "/images/" + fileName);
            }
        }
        req.setAttribute("listCTSP", listCTSP);
        req.getRequestDispatcher("/views/user/home-user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
