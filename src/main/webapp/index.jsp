<%--
  Created by IntelliJ IDEA.
  User: hania
  Date: 10/11/18
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="partials/head.jsp" %>
</head>
<body>


<%@ include file="partials/navbar.jsp" %>

<c:forEach var="item" begin="1" end="30">
    <c:choose>
        <c:when test="${item%15==0}">
            <p>FizzBuzz</p>
        </c:when>
        <c:when test="${item%3==0}">
            <p>Fizz</p>
        </c:when>
        <c:when test="${item%5==0}">
            <p>Buzz</p>
        </c:when>
        <c:otherwise>
            <p>${item}</p>
        </c:otherwise>
    </c:choose>
</c:forEach>


<%@ include file="partials/footer.jsp" %>

</body>
</html>
