package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.entities.ChucVu;
import com.poly.SD18103_SOF3011_ASM.entities.CuaHang;
import com.poly.SD18103_SOF3011_ASM.entities.NhanVien;
import com.poly.SD18103_SOF3011_ASM.repositories.ChucVuReposiroty;
import com.poly.SD18103_SOF3011_ASM.repositories.CuaHangRepository;
import com.poly.SD18103_SOF3011_ASM.repositories.NhanVienRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DateTimeConverter;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/view-add",
        "/nhan-vien/add",
        "/nhan-vien/delete",
        "/nhan-vien/detail",
        "/nhan-vien/update"
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepository = new NhanVienRepository();
    private ChucVuReposiroty chucVuReposiroty = new ChucVuReposiroty();
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
        NhanVien nhanVien = nhanVienRepository.getNhanVienByMa(ma);
        req.setAttribute("detailNhanVien", nhanVien);
        req.getRequestDispatcher("/views/admin/nhanvien/detail-nhan-vien.jsp").forward(req, resp);
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ma = req.getParameter("ma");
        NhanVien nhanVien = nhanVienRepository.getNhanVienByMa(ma);
        nhanVienRepository.delete(nhanVien);
        resp.sendRedirect("/nhan-vien/hien-thi");
    }

    private void viewAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<CuaHang> listCuaHang = cuaHangRepository.getAll();
        List<ChucVu> listChucVu = chucVuReposiroty.getAll();
        req.setAttribute("listCuaHang", listCuaHang);
        req.setAttribute("listChucVu", listChucVu);
        req.getRequestDispatcher("/views/admin/nhanvien/add-nhan-vien.jsp").forward(req, resp);
    }

    private void hienThi(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NhanVien> listNhanVien = nhanVienRepository.getAll();
        req.setAttribute("listNhanVien", listNhanVien);
        req.getRequestDispatcher("/views/admin/nhanvien/nhan-vien.jsp").forward(req, resp);
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

    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String ma = req.getParameter("ma");
            String ten = req.getParameter("ten");
            String tenDem = req.getParameter("tenDem");
            String ho = req.getParameter("ho");
//            String ngaySinh = req.getParameter("ngaySinh");
            String diaChi = req.getParameter("diaChi");
            String sdt = req.getParameter("sdt");
            String matKhau = req.getParameter("matKhau");
            UUID idCuaHang = UUID.fromString(req.getParameter("idCuaHang"));
            UUID idChucVu = UUID.fromString(req.getParameter("idChucVu"));

            if (ma.trim().isEmpty() || ten.trim().isEmpty() || tenDem.trim().isEmpty() || ho.trim().isEmpty()
                    || sdt.trim().isEmpty() || diaChi.trim().isEmpty() || matKhau.trim().isEmpty()) {
                req.getSession().setAttribute("mess_error", "Vui lòng nhập đầy đủ thông tin");
                resp.sendRedirect("/nhan-vien/view-add");
                return;
            }
            if(nhanVienRepository.getNhanVienByMa(ma) != null){
                req.getSession().setAttribute("mess_error", "Mã nhân viên đã tồn tại");
                resp.sendRedirect("/nhan-vien/view-add");
                return;
            }
            DateTimeConverter dtc = new DateConverter(new Date());
            dtc.setPattern("yyyy-MM-dd");
            ConvertUtils.register(dtc, Date.class);

            CuaHang cuaHang = new CuaHang();
            cuaHang.setId(idCuaHang);
            ChucVu chucVu = new  ChucVu();
            chucVu.setId(idChucVu);

            NhanVien nhanVien = new NhanVien();
            nhanVien.setCuaHang(cuaHang);
            nhanVien.setChucVu(chucVu);
            BeanUtils.populate(nhanVien, req.getParameterMap());
            if (nhanVienRepository.add(nhanVien)) {
                req.getSession().setAttribute("message", "Thêm thành công");
                resp.sendRedirect("/nhan-vien/hien-thi");
            } else {
                req.getSession().setAttribute("mess_error", "Thêm thất bại");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
