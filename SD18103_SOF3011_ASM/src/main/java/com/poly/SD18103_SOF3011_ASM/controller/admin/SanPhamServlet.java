package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.SanPham;
import com.poly.SD18103_SOF3011_ASM.repositories.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/view-add",
        "/san-pham/add",
        "/san-pham/delete",
        "/san-pham/detail",
        "/san-pham/update"
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();

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

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        SanPham sanPham = sanPhamRepository.getSanPhamByMa(ma);
        sanPhamRepository.delete(sanPham);
        resp.sendRedirect("/san-pham/hien-thi");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        SanPham sanPham = sanPhamRepository.getSanPhamByMa(ma);
        req.setAttribute("detailSanPham", sanPham);
        req.getRequestDispatcher("/views/admin/sanpham/detail-san-pham.jsp").forward(req, resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/views/admin/sanpham/add-san-pham.jsp");
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SanPham> list = sanPhamRepository.getAll();
        req.setAttribute("listSanPham", list);
        req.getRequestDispatcher("/views/admin/sanpham/san-pham.jsp").forward(req, resp);
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
            if(ma.trim().isEmpty() || ten.trim().isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng không được để trống");
                resp.sendRedirect("/san-pham/detail?ma=" + ma);
                return;
            }
            SanPham sanPham = new SanPham();
            BeanUtils.populate(sanPham, req.getParameterMap());
            if(sanPhamRepository.update(ma, sanPham)) {
                req.getSession().setAttribute("mess", "Cập nhật thành công");
                resp.sendRedirect("/san-pham/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Cập nhật thất bại");
                resp.sendRedirect("/san-pham/detail?ma=" + ma);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            if(ma.trim().isEmpty() || ten.trim().isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng không được để trống");
                resp.sendRedirect("/san-pham/view-add");
                return;
            }
            if(sanPhamRepository.getSanPhamByMa(ma) != null) {
                req.getSession().setAttribute("mess_error", "Mã sản phẩm đã tồn tại");
                resp.sendRedirect("/san-pham/view-add");
                return;
            }
            SanPham sanPham = new SanPham();
            BeanUtils.populate(sanPham, req.getParameterMap());
            if(sanPhamRepository.add(sanPham)) {
                req.getSession().setAttribute("mess", "Thêm thành công");
                resp.sendRedirect("/san-pham/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Thêm thất bại");
                resp.sendRedirect("/san-pham/view-add");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
