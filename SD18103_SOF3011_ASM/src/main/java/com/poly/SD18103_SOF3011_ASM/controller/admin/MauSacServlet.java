package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.MauSac;
import com.poly.SD18103_SOF3011_ASM.repositories.MauSacRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/view-add",
        "/mau-sac/add",
        "/mau-sac/delete",
        "/mau-sac/detail",
        "/mau-sac/update"
})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();

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
        MauSac mauSac = mauSacRepository.getMauSacByMa(ma);
        req.setAttribute("detailMauSac", mauSac);
        req.setAttribute("view_mauSac", "/views/admin/mausac/detail-mau-sac.jsp");
        req.getRequestDispatcher("/views/admin/home-admin.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        MauSac mauSac = mauSacRepository.getMauSacByMa(ma);
        mauSacRepository.delete(mauSac);
        resp.sendRedirect("/mau-sac/hien-thi");
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("view_mauSac", "/views/admin/mausac/add-mau-sac.jsp");
        req.getRequestDispatcher("/views/admin/home-admin.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MauSac> list = mauSacRepository.getAll();
        req.setAttribute("listMauSac", list);
        req.setAttribute("view_mauSac", "/views/admin/mausac/mau-sac.jsp");
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
            if(ma.trim().isEmpty() || ten.trim().isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng không để trống");
                resp.sendRedirect("/mau-sac/detail?ma=" + ma);
                return;
            }
            MauSac mauSac = new MauSac();
            BeanUtils.populate(mauSac, req.getParameterMap());
            if(mauSacRepository.update(ma, mauSac)) {
                req.getSession().setAttribute("mess", "Thêm thành công");
                resp.sendRedirect("/mau-sac/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Thêm thất bại");
                resp.sendRedirect("/mau-sac/detail?ma=" + ma);
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
                req.getSession().setAttribute("mess_error", "Vui lòng không để trống");
                resp.sendRedirect("/mau-sac/view-add");
                return;
            }
            if(mauSacRepository.getMauSacByMa(ma) != null) {
                req.getSession().setAttribute("mess_error", "Mã màu sắc đã tồn tại");
                resp.sendRedirect("/mau-sac/view-add");
                return;
            }
            MauSac mauSac = new MauSac();
            BeanUtils.populate(mauSac, req.getParameterMap());
            if(mauSacRepository.add(mauSac)) {
                req.getSession().setAttribute("mess", "Thêm thành công");
                resp.sendRedirect("/mau-sac/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Thêm thất bại");
                resp.sendRedirect("/mau-sac/view-add");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
