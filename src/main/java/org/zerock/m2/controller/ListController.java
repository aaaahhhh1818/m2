package org.zerock.m2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.m2.dto.MemberDTO;
import org.zerock.m2.dto.MsgDTO;
import org.zerock.m2.service.MsgService;
import sun.rmi.server.Dispatcher;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@Log4j2
@WebServlet(name = "ListController", value = "/msg/list")
public class ListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        log.info("list controller doGet..................................");

        // 로그인 체크 로직
        HttpSession session = request.getSession();
        Object memberObj = session.getAttribute("member");
        // 로그인 관련 정보 없음 - 로그인 안한 사용자
        if(memberObj == null) {
            response.sendRedirect("/login");
            return;
        }
        MemberDTO memberDTO = (MemberDTO)memberObj; //타입을 바꿔서 가져오는 것

        String user = memberDTO.getMid();

        Map<String, List<MsgDTO>> result = MsgService.INSTANCE.getList(user);

        //jsp(view)로 택배 전달
        request.setAttribute("Receive", result.get("R"));
        request.setAttribute("Send", result.get("S"));

       request.getRequestDispatcher("/WEB-INF/msg/list.jsp").forward(request, response);

    }

}