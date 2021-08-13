<%--
  Created by IntelliJ IDEA.
  User: 이아현
  Date: 2021-08-13
  Time: 오후 12:13
  To change this template use File | Settings | File Templates.
--%>

<%
  //HttpSession session = requet.getSession();
  
  Object obj = session.getAttribute("name");
  
  if(obj == null) {
      response.sendRedirect("/login.jsp");
      return;
  }
  
%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Write Page</h1>
    <h2><%=obj%></h2>

    <form action="/logout.jsp" method="post">
        <button type="submit">LOGOUT</button>
    </form>

</body>
</html>
