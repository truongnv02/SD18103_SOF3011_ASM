package com.poly.SD18103_SOF3011_ASM.controller.admin;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/view-add",
        "/cua-hang/add",
        "/cua-hang/delete",
        "/cua-hang/detail",
        "/cua-hang/update"
})
public class CuaHangServlet extends HttpServlet {
}
