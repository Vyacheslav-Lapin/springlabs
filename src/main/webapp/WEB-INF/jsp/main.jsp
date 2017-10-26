<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Main</title>
    <meta http-equiv="refresh" content="7;URL=/">
</head>
<body>

<h1>Hello!</h1>
You were redirected to this page<br/>
Now you can
<form action="${pageContext.request.contextPath}/" method="post">
    <input type="submit" value="Go to index page">
</form>
, or wait for 7 seconds for redirect automatically (by "meta" tag).
</body>
</html>