package com.poly.SD18103_SOF3011_ASM.filter;

import com.poly.SD18103_SOF3011_ASM.entities.NhanVien;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter({
        "/chuc-vu/*",
        "/cua-hang/*",
        "/nhan-vien/*",
        "/khach-hang/*",
        "/san-pham/*",
        "/nsx/*",
        "/mau-sac/*",
        "/dong-sp/*",
        "/chi-tiet-san-pham/*"

})
public class AdminFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        NhanVien nhanVien = (NhanVien) session.getAttribute("admin");
        if(nhanVien == null) {
            resp.sendRedirect("/account/login");
        }else {
            chain.doFilter(request, response);
        }
    }
}
