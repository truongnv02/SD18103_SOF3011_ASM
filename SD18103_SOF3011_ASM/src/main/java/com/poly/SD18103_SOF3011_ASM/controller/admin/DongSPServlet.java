package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.DongSP;
import com.poly.SD18103_SOF3011_ASM.repositories.DongSPRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "DongSPServlet", value = {
        "/dong-sp/hien-thi",
        "/dong-sp/view-add",
        "/dong-sp/add",
        "/dong-sp/delete",
        "/dong-sp/detail",
        "/dong-sp/update"
})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepository = new DongSPRepository();

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

    private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        String ma = req.getParameter("ma");
        DongSP dongSP = dongSPRepository.getDongSPByMa(ma);
        req.setAttribute("detailDongSP", dongSP);
        req.getRequestDispatcher("/views/admin/dongsanpham/detail-dong-sp.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        String ma = req.getParameter("ma");
        DongSP dongSP = dongSPRepository.getDongSPByMa(ma);
        dongSPRepository.delete(dongSP);
        resp.sendRedirect("/dong-sp/hien-thi");
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        resp.sendRedirect("/views/admin/dongsanpham/add-dong-sp.jsp");
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        List<DongSP> list = dongSPRepository.getAll();
        req.setAttribute("listDongSP", list);
        req.getRequestDispatcher("/views/admin/dongsanpham/dong-sp.jsp").forward(req, resp);
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

    private void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        try {
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            if(ma.trim().isEmpty() || ten.trim().isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng không để trống");
                resp.sendRedirect("/dong-sp/detail?ma=" + ma);
                return;
            }
            DongSP dongSP = new DongSP();
            BeanUtils.populate(dongSP, req.getParameterMap());
            if(dongSPRepository.update(ma, dongSP)) {
                req.getSession().setAttribute("mess", "Cập nhật thành công");
                resp.sendRedirect("/dong-sp/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Cập nhật thất bại");
                resp.sendRedirect("/dong-sp/detail?ma=" + ma);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        try {
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            if(ma.trim().isEmpty() || ten.trim().isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng không để trống");
                resp.sendRedirect("/dong-sp/view-add");
                return;
            }
            if(dongSPRepository.getDongSPByMa(ma) != null) {
                req.getSession().setAttribute("mess_error", "Mã dòng sản phẩm đã tồn tại");
                resp.sendRedirect("/dong-sp/view-add");
            }
            DongSP dongSP = new DongSP();
            BeanUtils.populate(dongSP, req.getParameterMap());
            if(dongSPRepository.add(dongSP)) {
                req.getSession().setAttribute("mess", "Thêm thành công");
                resp.sendRedirect("/dong-sp/hien-thi");
            }else {
                req.getSession().setAttribute("mess_error", "Thêm thất bại");
                resp.sendRedirect("/dong-sp/view-add");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
