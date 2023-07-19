package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.CuaHang;
import com.poly.SD18103_SOF3011_ASM.repositories.CuaHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/view-add",
        "/cua-hang/add",
        "/cua-hang/delete",
        "/cua-hang/detail",
        "/cua-hang/update"
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

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
        String ma = req.getParameter("ma");
        CuaHang cuaHang = cuaHangRepository.getCuaHangByMa(ma);
        req.setAttribute("detailCuaHang", cuaHang);
        req.getRequestDispatcher("/views/admin/cuahang/detail-cua-hang.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        CuaHang cuaHang = cuaHangRepository.getCuaHangByMa(ma);
        cuaHangRepository.delete(cuaHang);
        resp.sendRedirect("/cua-hang/hien-thi");
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/views/admin/cuahang/add-cua-hang.jsp");
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CuaHang> list = cuaHangRepository.getAll();
        req.setAttribute("listCuaHang", list);
        req.getRequestDispatcher("/views/admin/cuahang/cua-hang.jsp").forward(req, resp);
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
        try{
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            String diaChi = req.getParameter("diaChi");
            String thanhPho = req.getParameter("thanhPho");
            String quocGia = req.getParameter("quocGia");

            if(ma.trim().isEmpty() || ten.trim().isEmpty() || diaChi.trim().isEmpty() || thanhPho.trim().isEmpty() || quocGia.trim().isEmpty()) {
                req.setAttribute("mess_error", "Vui long khong de trong");
                resp.sendRedirect("/cua-hang/detail?ma=" + ma);
                return;
            }
            if(cuaHangRepository.getCuaHangByMa(ma) != null) {
                req.setAttribute("mess_error", "Ma da ton tai");
                resp.sendRedirect("/cua-hang/detail?ma=" + ma);
                return;
            }
            CuaHang cuaHang = new CuaHang();
            BeanUtils.populate(cuaHang, req.getParameterMap());
            if(cuaHangRepository.update(cuaHang)) {
                req.setAttribute("mess", "Cap nhat thanh cong");
                resp.sendRedirect("/cua-hang/hien-thi");
            }else {
                req.setAttribute("mess_error", "Cap nhat that bai");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            String diaChi = req.getParameter("diaChi");
            String thanhPho = req.getParameter("thanhPho");
            String quocGia = req.getParameter("quocGia");

            if(ma.trim().isEmpty() || ten.trim().isEmpty() || diaChi.trim().isEmpty() || thanhPho.trim().isEmpty() || quocGia.trim().isEmpty()) {
                req.setAttribute("mess_error", "Vui long khong de trong");
                resp.sendRedirect("/cua-hang/view-add");
                return;
            }
            if(cuaHangRepository.getCuaHangByMa(ma) != null) {
                req.setAttribute("mess_error", "Ma da ton tai");
                resp.sendRedirect("/cua-hang/view-add");
                return;
            }
            CuaHang cuaHang = new CuaHang();
            BeanUtils.populate(cuaHang, req.getParameterMap());
            if(cuaHangRepository.add(cuaHang)) {
                req.setAttribute("mess", "Them thanh cong");
                resp.sendRedirect("/cua-hang/hien-thi");
            }else {
                req.setAttribute("mess_error", "Them that bai");
            }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
