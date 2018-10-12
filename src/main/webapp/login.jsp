<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hania
  Date: 10/11/18
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="partials/head.jsp" %>

<% String user = request.getParameter("username");
String pass = request.getParameter("password");

if(user!=null && pass !=null)
    {
        if (user.equals("admin") && pass.equals("password"))
            response.sendRedirect("/profile.jsp");
    }
%>


<%--<c:if test="${(param.username == 'admin') && (param.password='password')}">--%>
    <%--String redirectURL = "http://localhost:8080/profile.jsp";--%>
    <%--response.sendRedirect(redirectURL);--%>
<%--</c:if>--%>


<html>
<head>
    <title>Login</title>
</head>
<body class="container pt-5">
<%@ include file="partials/navbar.jsp" %>


<form action="login.jsp" method="POST" class="p-5 border rounded" style="width: 50%">
    <div class="form-group row">
        <label for="inputUsername" class="col-sm-2 col-form-label">username</label>
        <div class="col-sm-10">
            <input type="text" class="form-control" id="inputUsername" placeholder="username" name="username">

        </div>
    </div>
    <div class="form-group row">
        <label for="inputPassword" class="col-sm-2 col-form-label">password</label>
        <div class="col-sm-10">
            <input type="password" class="form-control" id="inputPassword" placeholder="Password" name="password">
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Sign in</button>

</form>




<%@ include file="partials/footer.jsp" %>

</body
</html>>
