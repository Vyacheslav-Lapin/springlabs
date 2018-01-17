<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <title><s:message code="form.userlist.name"/></title>
</head>
<body>

<h3><s:message code="form.table.userlist.title"/></h3>
<table border="1">
    <tr>
        <th><s:message code="form.table.userlist.col.id"/></th>
        <th><s:message code="form.table.userlist.col.firstname"/></th>
        <th><s:message code="form.table.userlist.col.lastname"/></th>
    </tr>
    <c:forEach var="x" items="${userList}">
        <tr>
            <td>${x.id}</td>
            <td>${x.firstName}</td>
            <td>${x.lastName}</td>
        </tr>
    </c:forEach>
</table>

<hr/>

<a href="${pageContext.request.contextPath}/user/add.form">
    <s:message code="form.adduser.name"/></a>

</body>
</html>