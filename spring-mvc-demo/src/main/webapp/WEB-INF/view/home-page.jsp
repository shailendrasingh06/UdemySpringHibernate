<%--
  Created by IntelliJ IDEA.
  User: shail
  Date: 12-12-2021
  Time: 01:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome to the website guys!!!</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/test.css">
    <script src="${pageContext.request.contextPath}/resources/js/test.js"></script>
</head>
<body>
<div style="height: 25px; width: auto; align-content: center" > <h2>Welcome Shailendra!!! </h2></div>
<div>
    <a href="showForm">Hello World - Form link</a>
</div>
<img src="${pageContext.request.contextPath}/resources/img/download.png" width="177" height="284" />

<br>
<input type="button" onclick="doSomeWork()" value="Click me"/>
</body>
</html>
