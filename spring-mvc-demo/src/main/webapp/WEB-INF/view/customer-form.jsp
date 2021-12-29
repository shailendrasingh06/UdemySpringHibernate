<%--
  Created by IntelliJ IDEA.
  User: shail
  Date: 26-12-2021
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Customer Registration Form</title>
    <script src="${pageContext.request.contextPath}/resources/js/test.js"></script>
    <style>
        .error{
            color: red;
        }
    </style>
</head>
<body>
<i>Asterisk(*) means the field is required.</i>
<form:form action="processForm" modelAttribute="customer">
    First Name: <form:input path="firstName"></form:input>
    <br><br>
    Last Name(*): <form:input path="lastName"></form:input>
    <form:errors path="lastName" cssClass="error"></form:errors>
    <br><br>
    Age: <form:input path="age"></form:input>
    <form:errors path="age" cssClass="error"></form:errors>
    <br><br>
    Postal: <form:input path="postalCode"></form:input>
    <form:errors path="postalCode" cssClass="error"></form:errors>
    <br><br>
    <input type="submit" value="Proceed"> </input>

</form:form>
</body>
</html>
