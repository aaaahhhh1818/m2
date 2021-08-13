package org.zerock.m2.controller;

import lombok.With;
import lombok.extern.log4j.Log4j2;
import org.zerock.m2.dao.MemberDAO;
import org.zerock.m2.dto.MemberDTO;
import org.zerock.m2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController", value = "/login")
@Log4j2
public class LoginController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("GET login");

        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 파라미터 수집 mid mpw
        String mid = request.getParameter("mid");
        String mpw = request.getParameter("mpw");

//        // 사용자 정보 구한다.   ----> 사용자의 정보가 없다. --> 다시 GET방식으로 로그인페이지 값
//        MemberDTO memberDTO = MemberDTO.builder()
//                .mid(mid)
//                .mpw(mpw)
//                .mname("사용자" + mid)
//                .nickname("사용자" + mid)
//                .build();
        try {

            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
            // 세션에 setAttribute("member", 사용자 정보)
            HttpSession session = request.getSession();
            session.setAttribute("member", memberDTO);

            // /msg/list 로 리다이렉트 시킨다.
            response.sendRedirect("/msg/list");

        }catch (Exception e) {
            log.error("Login Fail.." + e.getMessage());
            response.sendRedirect("/login?result=fail");
        }

    }
}
