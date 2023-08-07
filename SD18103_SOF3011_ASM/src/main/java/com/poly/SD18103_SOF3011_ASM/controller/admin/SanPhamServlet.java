package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.SanPham;
import com.poly.SD18103_SOF3011_ASM.repositories.SanPhamRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@MultipartConfig
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
        req.setAttribute("view_sanPham", "/views/admin/sanpham/detail-san-pham.jsp");
        req.getRequestDispatcher("/views/admin/home-admin.jsp").forward(req, resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("view_sanPham", "/views/admin/sanpham/add-san-pham.jsp");
        req.getRequestDispatcher("/views/admin/home-admin.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<SanPham> list = sanPhamRepository.getAll();
        String realPath = req.getServletContext().getRealPath("/images");
        // hien thi hinh anh
        for(SanPham sp : list) {
            String fileName = sp.getImage();
            if(fileName != null) {
                sp.setImage(req.getContextPath() + "/images/" + fileName);
            }
        }
        req.setAttribute("listSanPham", list);
        req.setAttribute("view_sanPham", "/views/admin/sanpham/san-pham.jsp");
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
            Part part = req.getPart("image");
            String realPath = req.getServletContext().getRealPath("/images");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            // kiem tra de trong
            if(ma.trim().isEmpty() || ten.trim().isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng không được để trống");
                resp.sendRedirect("/san-pham/detail?ma=" + ma);
                return;
            }
            // kiem tra chon anh
            if (fileName.isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng chọn ảnh");
                resp.sendRedirect("/san-pham/detail?ma=" + ma);
                return;
            }
            //update
            part.write(realPath + "/" + fileName);
            req.setAttribute("image", fileName);
            SanPham sanPham = new SanPham();
            sanPham.setImage(fileName);

            BeanUtils.populate(sanPham, req.getParameterMap());
            if(sanPhamRepository.update(ma, sanPham)) {
                req.getSession().setAttribute("mess", "Thêm thành công");
                resp.sendRedirect("/san-pham/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Thêm thất bại");
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
            Part part = req.getPart("image");
            String realPath = req.getServletContext().getRealPath("/images");
            String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
            if(!Files.exists(Paths.get(realPath))) {
                Files.createDirectories(Paths.get(realPath));
            }
            part.write(realPath + "/" + fileName);
            // kiem tra de trong
            if(ma.trim().isEmpty() || ten.trim().isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng không được để trống");
                resp.sendRedirect("/san-pham/view-add");
                return;
            }
            // kiem tra chon anh
            if (fileName.isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng chọn ảnh");
                resp.sendRedirect("/san-pham/view-add");
                return;
            }
            // kiem tra trung ma
            if(sanPhamRepository.getSanPhamByMa(ma) != null) {
                req.getSession().setAttribute("mess_error", "Mã sản phẩm đã tồn tại");
                resp.sendRedirect("/san-pham/view-add");
                return;
            }
            //add
            req.setAttribute("image", fileName);
            SanPham sanPham = new SanPham();
            sanPham.setImage(part.getSubmittedFileName());

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
