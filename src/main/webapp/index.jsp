<%@ page session="false" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <title>Hello, World!</title>
    </head>

    <body>
        <form action="${pageContext.request.contextPath}/StandaloneController"
              method="post">
            <input name="Form Button" type="submit">
        </form>
    </body>

</html>
