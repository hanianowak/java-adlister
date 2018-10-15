<%@ page import="adlister.ListAdsDao" %>
<%@ page import="adlister.Ad" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--Use the all method on the adlister.ListAdsDao class to get a listing of all the ads, and pass this on to your jsp file--%>
<table>
    <tr>
        <th>Title</th>
        <th>Description</th>
    </tr>
    <% for (Ad a : new ListAdsDao().all()) {%>
    <tr>
        <td><%= a.getTitle() %>
        </td>
        <td><%= a.getDescription()%>
        </td>
    </tr>
    <% } %>
</table>
