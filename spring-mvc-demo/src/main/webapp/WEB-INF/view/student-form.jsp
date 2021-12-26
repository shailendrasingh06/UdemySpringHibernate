<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: shail
  Date: 25-12-2021
  Time: 00:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<form:form action="processStudentForm" modelAttribute="student">
    First Name: <form:input path="firstName"></form:input>
    <br><br>
    Last Name: <form:input path="lastName"/>
    <br><br>
    Email:     <form:input path="email"/>
    <br><br>
    Password: <form:password path="pass"/>
    <br><br>
    Country:  <form:select path="country">
    <form:options items="${student.countryOptions}"/>
    </form:select>
    <br><br>
    Coding Lang: <form:radiobuttons path="favouriteLang" items="${student.languageOptions}"/>
    <br><br>


    <br><br>
    <input type="submit" value="Submit Form">

</form:form>
</body>
</html>
