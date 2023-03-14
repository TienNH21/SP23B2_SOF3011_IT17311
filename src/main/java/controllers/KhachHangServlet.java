package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import view_model.QLKhachHang;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet({
    "/khach-hang/index",    // GET
    "/khach-hang/create",   // GET
    "/khach-hang/edit",     // GET
    "/khach-hang/delete",   // GET
    "/khach-hang/store",    // POST
    "/khach-hang/update",   // POST
})
public class KhachHangServlet extends HttpServlet {
    private ArrayList<QLKhachHang> list = new ArrayList<>();

    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
//            this.edit(request, response);
        } else if (uri.contains("delete")) {
//            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void index(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        this.list.add(new QLKhachHang("PH1", "Ng", "Van", "AA", "12/12/2021", "0123123123", "HN", "123", "VN", "HN"));
        this.list.add(new QLKhachHang("PH2", "Tran", "Van", "BB", "12/12/2021", "0123123123", "HN", "123", "VN", "HN"));
        request.setAttribute("danhSachKH", this.list);
        request.getRequestDispatcher("/views/khach_hang/index.jsp")
            .forward(request, response);
    }

    protected void create(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        request.getRequestDispatcher("/views/khach_hang/create.jsp")
            .forward(request, response);
    }

    @Override
    protected void doPost(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        this.store(request, response);
    }

    protected void store(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String ho = request.getParameter("ho");
        String ten_dem = request.getParameter("ten_dem");
        String ten = request.getParameter("ten");
        String sdt = request.getParameter("sdt");
        String mat_khau = request.getParameter("mat_khau");
        String dia_chi = request.getParameter("dia_chi");
        String thanh_pho = request.getParameter("thanh_pho");
        String quoc_gia = request.getParameter("quoc_gia");
        String ngay_sinh = request.getParameter("ngay_sinh");

        QLKhachHang vm = new QLKhachHang(ma, ho, ten_dem, ten, ngay_sinh, sdt, dia_chi, mat_khau, quoc_gia, thanh_pho);
        list.add(vm);
    }
}
