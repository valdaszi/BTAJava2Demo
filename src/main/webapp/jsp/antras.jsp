<%--
  Created by IntelliJ IDEA.
  User: valdas
  Date: 21/10/2018
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Antras</title>
</head>
<body>
    <jsp:useBean id="counterBean" class="lt.bta.java2.bean.CounterBean" scope="session">
        <%-- intialize bean properties --%>
        <jsp:setProperty name="counterBean" property="name" value="Skaitliukas B"/>
    </jsp:useBean>

    <h1>Antras: ${counterBean.name} = ${counterBean.count}</h1>

    <%
        // mazinam skaitliuka
        counterBean.setCount(counterBean.getCount() - 1);
    %>

    <a href="pirmas.jsp">Pirmas</a>
    <a href="trecias.jsp">Trečias</a>
</body>
</html>
