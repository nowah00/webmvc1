package com.ssg.webmvc.todo.controller;

import com.ssg.webmvc.todo.dto.MemberDTO;
import com.ssg.webmvc.todo.service.MemberService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Log4j2
@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("LoginController doGet() 호출");
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("LoginController doPost() 호출");

        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        try {
            MemberDTO dto = MemberService.INSTANCE.login(mid,mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", dto);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            resp.sendRedirect("/login?result=error");
        }


    }
}
