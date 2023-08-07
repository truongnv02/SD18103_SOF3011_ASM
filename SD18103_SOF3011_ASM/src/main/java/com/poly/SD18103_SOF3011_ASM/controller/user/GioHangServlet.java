package com.poly.SD18103_SOF3011_ASM.controller.user;

import com.poly.SD18103_SOF3011_ASM.entities.ChiTietSP;
import com.poly.SD18103_SOF3011_ASM.entities.GioHang;
import com.poly.SD18103_SOF3011_ASM.entities.GioHangChiTiet;
import com.poly.SD18103_SOF3011_ASM.entities.KhachHang;
import com.poly.SD18103_SOF3011_ASM.repositories.ChiTietSanPhamRepository;
import com.poly.SD18103_SOF3011_ASM.repositories.GioHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "GioHangServlet", value = {
        "/ban-hang/gio-hang",
        "/ban-hang/add",
        "/ban-hang/delete",
        "/ban-hang/update"
})
public class GioHangServlet extends HttpServlet {
    private GioHangRepository gioHangRepository = new GioHangRepository();
    private ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("gio-hang")) {
            this.cart(req, resp);
        }else if(uri.contains("delete")) {
            this.delete(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UUID id = UUID.fromString(req.getParameter("id"));

    }

    private void cart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        HttpSession session = req.getSession();
        List<GioHangChiTiet> listGioHangChiTiet = gioHangRepository.getAllGioHangChiTiet();
        // hien thi hinh anh
        for(GioHangChiTiet ghct : listGioHangChiTiet) {
            String fileName = ghct.getChiTietSP().getSanPham().getImage();
            if(fileName != null) {
                ghct.getChiTietSP().getSanPham().setImage(req.getContextPath() + "/images/" + fileName);
            }
        }
        req.setAttribute("listGioHangChiTiet", listGioHangChiTiet);
        req.getRequestDispatcher("/views/user/giohang/gio-hang.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("add")) {
            this.addCart(req, resp);
        }else if(uri.contains("update")) {
            this.updateCart(req, resp);
        }
    }

    private void updateCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    private void addCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        UUID id = UUID.fromString(req.getParameter("id"));
        int soLuong = Integer.parseInt(req.getParameter("soLuong"));
        ChiTietSP chiTietSP = chiTietSanPhamRepository.getCTSPById(id);

        GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
        gioHangChiTiet.setChiTietSP(chiTietSP);
        
    }
}
