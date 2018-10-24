<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: valdas
  Date: 22/10/20
  Time: 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ketvirtas</title>
</head>
<body>
    <h1>Oooo, aš esu ketvirtas</h1>

    <%! int b = 10; %>
    <%
       int a = new Random().nextInt();
       request.setAttribute("m1", a / b);
    %>
    <h2>Atsitiktinis skaiciukas yra <%= a %> arba ${m1}</h2>

</body>
</body>
</html>