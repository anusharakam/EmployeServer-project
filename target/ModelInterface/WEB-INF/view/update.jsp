<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>edit page</title>
</head>
<body>
<center>


    <h1>Edit Employee</h1>
    <%--@elvariable id="employeeDetails" type=""--%>
    <form:form modelAttribute="employee" action="../updateEmployee" method="post">
        <label>employeeId :</label>
        <input name="employeeId" readonly  value="${employee.employeeId}"/><br>
        <label>name :</label>
        <input name="name" value="${employee.name}"/><br>
        <label>email :</label>
        <input name="email" value="${employee.email}"/><br>
        <label>password :</label>
        <input name="password" value="${employee.password}"/><br>
        <label>department :</label>
        <input name="department" value="${employee.department}"/><br>
        <label>salary :</label>
        <input name="salary" value="${employee.salary}"/><br>
        <label>phoneNumber :</label>
        <input name="phoneNumber" value="${employee.phoneNumber}"/><br>
        <label>address :</label>
        <input name="address" value="${employee.address}"/><br>

        <input type="submit" value="Update">
    </form:form>
    <br>
    <a href="/viewCompanyList">Back</a>
</center>
</body>
</html>