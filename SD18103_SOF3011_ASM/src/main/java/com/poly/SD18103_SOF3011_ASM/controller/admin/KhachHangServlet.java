package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.KhachHang;
import com.poly.SD18103_SOF3011_ASM.repositories.KhachHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/view-add",
        "/khach-hang/add",
        "/khach-hang/delete",
        "/khach-hang/detail",
        "/khach-hang/update"
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepository khachHangRepository = new KhachHangRepository();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        if(uri.contains("hien-thi")) {
            this.hienThi(req, resp);
        }else if(uri.contains("view-add")) {
            this.viewAdd(req, resp);
        }else if(uri.contains("detail")) {
            this.detail(req, resp);
        }else if(uri.contains("delete")) {
            this.delete(req, resp);
        }else {
            this.hienThi(req, resp);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        KhachHang khachHang = khachHangRepository.getKhachHangByMa(ma);
        khachHangRepository.delete(khachHang);
        resp.sendRedirect("/khach-hang/hien-thi");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        KhachHang khachHang = khachHangRepository.getKhachHangByMa(ma);
        req.setAttribute("detailKhachHang", khachHang);
        req.setAttribute("view_khachHang", "/views/admin/khachhang/detail-khach-hang.jsp");
        req.getRequestDispatcher("/views/admin/home-admin.jsp").forward(req, resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("view_khachHang", "/views/admin/khachhang/add-khach-hang.jsp");
        req.getRequestDispatcher("/views/admin/home-admin.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<KhachHang> listKhachHang = khachHangRepository.getAll();
        req.setAttribute("listKhachHang", listKhachHang);
        req.setAttribute("view_khachHang", "/views/admin/khachhang/khach-hang.jsp");
        req.getRequestDispatcher("/views/admin/home-admin.jsp").forward(req, resp);
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
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            String tenDem = req.getParameter("tenDem");
            String ho = req.getParameter("ho");
            String sdt = req.getParameter("sdt");
            String diaChi = req.getParameter("diaChi");
            String thanhPho = req.getParameter("thanhPho");
            String quocGia = req.getParameter("quocGia");
            String matKhau = req.getParameter("matKhau");
            if(ma.trim().isEmpty() || ten.trim().isEmpty() || tenDem.trim().isEmpty() || ho.trim().isEmpty() || sdt.trim().isEmpty()
                    || diaChi.trim().isEmpty() || thanhPho.trim().isEmpty() || quocGia.trim().isEmpty() || matKhau.trim().isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng không để trống");
                resp.sendRedirect("/khach-hang/detail?ma=" + ma);
                return;
            }
            KhachHang khachHang = new KhachHang();
            BeanUtils.populate(khachHang, req.getParameterMap());
            if(khachHangRepository.update(khachHang)) {
                req.setAttribute("mess", "Cập nhật thành công");
                resp.sendRedirect("/khach-hang/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Cập nhật thất bại");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            String tenDem = req.getParameter("tenDem");
            String ho = req.getParameter("ho");
            String sdt = req.getParameter("sdt");
            String diaChi = req.getParameter("diaChi");
            String thanhPho = req.getParameter("thanhPho");
            String quocGia = req.getParameter("quocGia");
            String matKhau = req.getParameter("matKhau");
            if(ma.trim().isEmpty() || ten.trim().isEmpty() || tenDem.trim().isEmpty() || ho.trim().isEmpty() || sdt.trim().isEmpty()
                    || diaChi.trim().isEmpty() || thanhPho.trim().isEmpty() || quocGia.trim().isEmpty() || matKhau.trim().isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng không để trống");
                resp.sendRedirect("/khach-hang/view-add");
                return;
            }
            if(khachHangRepository.getKhachHangByMa(ma) != null) {
                req.getSession().setAttribute("mess_error", "Mã khách hàng đã tồn tại");
                resp.sendRedirect("/khach-hang/view-add");
                return;
            }
            KhachHang khachHang = new KhachHang();
            BeanUtils.populate(khachHang, req.getParameterMap());
            if(khachHangRepository.add(khachHang)) {
                req.setAttribute("mess", "Thêm thành công");
                resp.sendRedirect("/khach-hang/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Thêm thất bại");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
