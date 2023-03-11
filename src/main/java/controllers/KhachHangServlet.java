package controllers;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet({
    "/khach-hang/index",    // GET
    "/khach-hang/create",   // GET
    "/khach-hang/edit",     // GET
    "/khach-hang/delete",   // GET
    "/khach-hang/store",    // POST
    "/khach-hang/update",   // POST
})
public class KhachHangServlet extends HttpServlet {
    @Override
    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException, IOException {
        this.create(request, response);
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
        System.out.println(ma);
    }
}
