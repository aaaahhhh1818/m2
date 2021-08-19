<%--
  Created by IntelliJ IDEA.
  User: 이아현
  Date: 2021-08-17
  Time: 오전 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%

    Cookie cookie = new Cookie("sample", "1111");

    cookie.setMaxAge(60 * 60 * 24); //1day(하루동안 이 창 보지 않기) //setMaxAge -> 초단위로 줌

    response.addCookie(cookie); //브라우저로 보낼때 http의 헤더가 cookie로 바뀜

%>

<h1>쿠키가 만들어 졌음...</h1>

</body>
</html>
