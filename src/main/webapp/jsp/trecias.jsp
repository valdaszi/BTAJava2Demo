<%--
  Created by IntelliJ IDEA.
  User: valdas
  Date: 21/10/2018
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trečias</title>
</head>
<body>
<jsp:useBean id="counterBean" class="lt.bta.java2.bean.CounterBean" scope="session"/>

<%
    if (counterBean.getCount() == 0) {
        response.sendRedirect("pirmas.jsp");
    }
%>
<h2>Trečias</h2>

<a href="pirmas.jsp">Pirmas</a>
<a href="antras.jsp">Antras</a>

</body>
</html>
