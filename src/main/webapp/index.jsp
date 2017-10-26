<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <title>Hello, World!</title>
</head>

<body>
    <ul>
        <li><a href="${pageContext.request.contextPath}/log">Logging controller</a></li>
        <li><a href="${pageContext.request.contextPath}/hello-world">Hello, World!</a></li>
        <li><a href="${pageContext.request.contextPath}/parametrized">Parametrized controller</a></li>
        <li><a href="${pageContext.request.contextPath}/redirect">Redirecting controller</a></li>
        <li>
            <form action="${pageContext.request.contextPath}/form-parse" method="get">
                <input type="hidden" name="command" value="forward"/>

                Enter login:<br/>
                <input name="login" title="login"/><br/>

                Enter password:<br/>
                <input type="password" name="password" title="password"/><br/>

                <input type="submit" value="Отправить"/><br/>
            </form>
        </li>
    </ul>


</body>

</html>
