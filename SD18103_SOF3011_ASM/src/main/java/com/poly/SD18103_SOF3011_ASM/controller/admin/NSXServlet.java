package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.NSX;
import com.poly.SD18103_SOF3011_ASM.repositories.NSXRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "NSXServlet", value = {
        "/nsx/hien-thi",
        "/nsx/view-add",
        "/nsx/add",
        "/nsx/delete",
        "/nsx/detail",
        "/nsx/update"
})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepository = new NSXRepository();

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
        NSX nsx = nsxRepository.getNSXByMa(ma);
        req.setAttribute("detailNSX", nsx);
        req.getRequestDispatcher("/views/admin/nsx/detail-nsx.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        NSX nsx = nsxRepository.getNSXByMa(ma);
        nsxRepository.delete(nsx);
        resp.sendRedirect("/nsx/hien-thi");
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/views/admin/nsx/add-nsx.jsp");
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NSX> list = nsxRepository.getAll();
        req.setAttribute("listNSX", list);
        req.getRequestDispatcher("/views/admin/nsx/nsx.jsp").forward(req, resp);
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
                resp.sendRedirect("/nsx/detail?ma=" + ma);
                return;
            }
            NSX nsx = new NSX();
            BeanUtils.populate(nsx, req.getParameterMap());
            if(nsxRepository.update(ma, nsx)) {
                req.getSession().setAttribute("mess", "Cập nhật thành công");
                resp.sendRedirect("/nsx/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Cập nhật thất bại");
                resp.sendRedirect("/nsx/detail?ma=" + ma);
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
                resp.sendRedirect("/nsx/view-add");
                return;
            }
            if(nsxRepository.getNSXByMa(ma) != null) {
                req.getSession().setAttribute("mess_error", "Mã nsx đã tồn tại");
                resp.sendRedirect("/nsx/view-add");
                return;
            }
            NSX nsx = new NSX();
            BeanUtils.populate(nsx, req.getParameterMap());
            if(nsxRepository.add(nsx)) {
                req.getSession().setAttribute("mess", "Thêm thành công");
                resp.sendRedirect("/nsx/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Thêm thất bại");
                resp.sendRedirect("/nsx/view-add");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
