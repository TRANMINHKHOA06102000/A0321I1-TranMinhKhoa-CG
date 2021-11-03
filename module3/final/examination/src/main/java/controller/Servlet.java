package controller;

import model.bean.BenhAn;
import model.bean.BenhNhan;
import model.service.BenhAnService;
import model.service.BenhNhanService;
import model.service.impl.BenhAnServiceImpl;
import model.service.impl.BenhNhanServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "Servlet", urlPatterns = {"", "/benhan"})
public class Servlet extends HttpServlet {
    BenhAnService benhAnService = new BenhAnServiceImpl();
    BenhNhanService benhNhanService = new BenhNhanServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                update(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int ma_benh_an = Integer.parseInt(request.getParameter("ma_benh_an"));
        int ma_benh_nhan = Integer.parseInt(request.getParameter("ma_benh_nhan"));
        String ngay_nhap_vien = request.getParameter("ngay_nhap_vien");
        String ngay_ra_vien = request.getParameter("ngay_ra_vien");
        String ly_do = request.getParameter("ly_do");
        String ten_benh_nhan = request.getParameter("ten_benh_nhan");
        BenhAn benhAn = new BenhAn(ma_benh_an, ma_benh_nhan, ten_benh_nhan, ngay_nhap_vien, ngay_ra_vien, ly_do);
        Map<String, String> mapMessage = benhAnService.edit(benhAn);
        if (!mapMessage.isEmpty()) {
            request.setAttribute("benhAn", benhAn);
            try {
                showUpdateForm(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                request.setAttribute("message", "sửa thành công");
                showList(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("idDelete"));
        benhAnService.delete(id);
        try {
            request.setAttribute("message", "xóa thành công");
            showList(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "update":
                try {
                    showUpdateForm(request, response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    showList(request, response);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        BenhAn benhAn = benhAnService.findById(id);
        List<BenhNhan> benhNhanList = benhNhanService.findAll();
        request.setAttribute("benhNhanList", benhNhanList);
        request.setAttribute("benhAn", benhAn);
        request.getRequestDispatcher("/benhan/edit.jsp").forward(request, response);
    }

    private void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<BenhAn> benhAnList = benhAnService.findAll();
        request.setAttribute("benhAnList", benhAnList);
        request.getRequestDispatcher("/benhan/list.jsp").forward(request, response);
    }
}
