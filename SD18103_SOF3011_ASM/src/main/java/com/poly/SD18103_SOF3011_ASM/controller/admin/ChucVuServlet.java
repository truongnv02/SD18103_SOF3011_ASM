package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.ChucVu;
import com.poly.SD18103_SOF3011_ASM.repositories.ChucVuReposiroty;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/view-add",
        "/chuc-vu/add",
        "/chuc-vu/delete",
        "/chuc-vu/detail",
        "/chuc-vu/update"
})
public class ChucVuServlet extends HttpServlet {
    private ChucVuReposiroty chucVuReposiroty = new ChucVuReposiroty();

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
        ChucVu chucVu = chucVuReposiroty.getChucVuByMa(ma);
        chucVuReposiroty.delete(chucVu);
        resp.sendRedirect("/chuc-vu/hien-thi");
    }

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        ChucVu chucVu = chucVuReposiroty.getChucVuByMa(ma);
        req.setAttribute("detailChucVu", chucVu);
        req.getRequestDispatcher("/views/admin/chucvu/detail-chuc-vu.jsp").forward(req, resp);
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/views/admin/chucvu/add-chuc-vu.jsp");
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ChucVu> listChuVu = chucVuReposiroty.getAll();
        req.setAttribute("listChucVu", listChuVu);
        req.getRequestDispatcher("/views/admin/chucvu/chuc-vu.jsp").forward(req, resp);
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
            if(ma.trim().isEmpty() || ten.trim().isEmpty()) {
                req.setAttribute("mess_error", "Vui long khong de trong");
                resp.sendRedirect("/chuc-vu/detail?ma=" + ma);
                return;
            }
            ChucVu chucVu = new ChucVu();
            BeanUtils.populate(chucVu, req.getParameterMap());
            if(chucVuReposiroty.update(ma, chucVu)) {
                req.setAttribute("mess", "Cap nhat thanh cong");
                resp.sendRedirect("/chuc-vu/hien-thi");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            if(ma.trim().isEmpty() || ten.trim().isEmpty()) {
                req.setAttribute("mess_error", "Vui long khong de trong");
                resp.sendRedirect("/chuc-vu/view-add");
                return;
            }
            if(chucVuReposiroty.getChucVuByMa(ma) != null) {
                req.setAttribute("mess_error", "Ma da ton tai");
                resp.sendRedirect("/chuc-vu/view-add");
                return;
            }
            ChucVu chucVu = new ChucVu();
            BeanUtils.populate(chucVu, req.getParameterMap());
            if(chucVuReposiroty.add(chucVu)) {
                req.setAttribute("mess", "Them thanh cong");
                resp.sendRedirect("/chuc-vu/hien-thi");
            }else {
                req.setAttribute("mess_error", "Them that bai");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
