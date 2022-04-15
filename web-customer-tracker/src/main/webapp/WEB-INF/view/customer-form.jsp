<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: shail
  Date: 28-03-2022
  Time: 01:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer Form</title>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="parent-wrapper1">
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>
    <div id="container">
        <h3>Save Customer</h3>
    </div>
    <form:form action="saveCustomer" modelAttribute="customer" method="POST">
        <!-- Need to associate this data with customer id -->
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>First Name : </label></td>
                <td><form:input path="first_name" /></td>
            </tr>
            <tr>
                <td><label>Last Name : </label></td>
                <td><form:input path="last_name" /></td>
            </tr>
            <tr>
                <td><label>Email : </label></td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td><label>Profile Pic : </label></td>
                <td><input type="file" id="profileImage" oninput="previewImage()"/></td>
            </tr>
            </tbody>
        </table>
        <input type="submit" value="Save" class="save"/>

    </form:form>
    <div id="backtolist">
        <p>
            <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
        </p>
    </div>
</div>

<div id="parent-wrapper2">
    <div id="container2">
        <img src="${pageContext.request.contextPath}/resources/images/Goku.png" alt="Cutomer Profile Picture" id="imagePreviewer"/>
    </div>
</div>
<script type="text/javascript">
    function previewImage() {
        var input = document.getElementById("profileImage");
        var fReader = new FileReader();
        fReader.readAsDataURL(input.files[0]);
        fReader.onloadend = function(event){
            var img = document.getElementById("imagePreviewer");
            img.src = event.target.result;
        }
    }
</script>
</body>
</html>
