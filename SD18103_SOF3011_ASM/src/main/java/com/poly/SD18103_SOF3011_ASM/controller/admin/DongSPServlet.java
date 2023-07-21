package com.poly.SD18103_SOF3011_ASM.controller.admin;

import com.poly.SD18103_SOF3011_ASM.repositories.DongSPRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
