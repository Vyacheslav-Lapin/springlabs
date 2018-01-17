<%@ page contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <!-- TODO: Try to use tag "spring:message" instead of direct message below-->
    <title>Add User Form</title>
</head>
<body>

<h3><s:message code="form.adduser.name"/></h3>
<sf:form modelAttribute="userFormBean">
    <table>
        <tr>
            <!-- TODO: Try to use tag "spring:message" instead of direct message below-->
            <td>First Name:</td>
            <td><sf:input path="firstName"/></td>
        </tr>
        <tr>
            <td colspan="2" style="color: red; font-size: small;">
                <sf:errors path="firstName"/>
            </td>
        </tr>
        <tr>
            <td><s:message code="name.last"/></td>
            <td><sf:input path="lastName"/></td>
        </tr>
        <tr>
            <td colspan="2" style="color: red; font-size: small;">
                <sf:errors path="lastName"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Save Changes"/></td>
        </tr>
    </table>
</sf:form>

</body>
</html>