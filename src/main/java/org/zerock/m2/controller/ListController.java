package org.zerock.m2.controller;

import lombok.extern.log4j.Log4j2;
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

        String user = request.getParameter("whom");

        Map<String, List<MsgDTO>> result = MsgService.INSTANCE.getList(user);

        //jsp(view)로 택배 전달
        request.setAttribute("Receive", result.get("R"));
        request.setAttribute("Send", result.get("S"));

       request.getRequestDispatcher("/WEB-INF/msg/list.jsp").forward(request, response);

    }

}