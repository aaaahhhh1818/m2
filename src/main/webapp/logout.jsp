<%--
  Created by IntelliJ IDEA.
  User: 이아현
  Date: 2021-08-13
  Time: 오후 12:39
  To change this template use File | Settings | File Templates.
--%>
<%
    //HttpSession session = request.getSession();

    session.removeAttribute("name"); //값을 지우고 진행하는 것이 안전함
    session.invalidate(); //시간지나면 버려라
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>
