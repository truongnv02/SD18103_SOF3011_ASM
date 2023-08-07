package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.KhachHang;
import com.poly.SD18103_SOF3011_ASM.entities.NhanVien;
import com.poly.SD18103_SOF3011_ASM.repositories.KhachHangRepository;
import com.poly.SD18103_SOF3011_ASM.repositories.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginAdminServlet", value = {
        "/account/login",
        "/account/check"
})
public class LoginServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("login")) {
            this.login(req, resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/user/account/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("check")) {
            this.checkLoginNhanVien(req, resp);
        }
    }

    private void checkLoginNhanVien(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        String matKhau = req.getParameter("matKhau");
        if(ma.trim().isEmpty() || matKhau.trim().isEmpty()) {
            req.getSession().setAttribute("mess_error", "Vui lòng không để trống");
            resp.sendRedirect("/account/login");
            return;
        }

        // nhan vien
        if(nhanVienRepository.checkLoginNhanVien(ma, matKhau) == null) {
            req.getSession().setAttribute("mess_error", "Tài khoản hoặc mật khẩu sai");
            resp.sendRedirect("/account/login");
            return;
        }
        NhanVien nhanVien = nhanVienRepository.checkLoginNhanVien(ma, matKhau);
        if(nhanVien != null) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", nhanVien);
            req.getRequestDispatcher("/views/admin/home-admin.jsp").forward(req, resp);
        }

//        //khach hang
//        if(khachHangRepository.checkLoginKhachHang(ma, matKhau) == null) {
//            req.getSession().setAttribute("mess_error", "Tài khoản hoặc mật khẩu sai");
//            resp.sendRedirect("/account/login");
//            return;
//        }
//        KhachHang khachHang = khachHangRepository.checkLoginKhachHang(ma, matKhau);
//        if(khachHang != null) {
//            HttpSession session = req.getSession();
//            session.setAttribute("user", khachHang);
//            req.getRequestDispatcher("/views/user/home-user.jsp").forward(req, resp);
//        }
    }
}
