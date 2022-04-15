<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
    <title>List Customers</title>

    <!-- reference our style sheet -->

    <link type="text/css"
          rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

<div id="parent-wrapper1">
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">

        <div id="content">

            <div class="actionPanel">
                <input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;"
                       class="add-button">
                <form:form action="search" method="get" id="searchForm">
                    <input id="searchbox1" type="text" placeholder="Search Customer...." name="searchName">
                    <input type="submit" name="Submit" value="Search" class="add-button" id="search-btn"/>
                </form:form>

            </div>
            <!--  add our html table here -->

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th colspan="3">Action</th>
                </tr>

                <!-- loop over and print our customers -->
                <c:forEach var="tempCustomer" items="${customers}">

                    <!-- construct an "delete" link with custmer Id  -->
                    <c:url var="updateLink" value="/customer/showFormForUpdate">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>

                    <!-- construct an "delete" link with custmer Id  -->
                    <c:url var="deleteLink" value="/customer/deleteCustomer">
                        <c:param name="customerId" value="${tempCustomer.id}"/>
                    </c:url>
                    <!-- loop over and print our customers -->

                    <tr>
                        <td> ${tempCustomer.first_name} </td>
                        <td> ${tempCustomer.last_name} </td>
                        <td> ${tempCustomer.email} </td>
                        <td><a href="${updateLink}">Update</a> </td>
                        <td><a href="${deleteLink}"
                               onclick="if(!(confirm('Are you sure you want to delete this customer from the list ?'))) return false">Delete</a> </td>
                        <td><a href="">View Profile</a> </td>
                    </tr>

                </c:forEach>

            </table>

        </div>

    </div>
</div>
<div id="parent-wrapper2">
    <div id="container2">
        <img src="" alt="Cutomer Profile Picture" style="margin: 100px 20px auto;height: 400px;width: 400px;"/>
    </div>
</div>
<script>
    function submitForm(){
        document.getElementById("searchForm").submit();
    }
</script>

</body>

</html>









