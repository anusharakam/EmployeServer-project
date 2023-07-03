
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table border="1" cellspacing="0">
<tr>
        <th>employeeId</th>
        <th>name</th>
        <th>email</th>
        <th>password</th>
        <th>department</th>
        <th>salary</th>
        <th>phoneNumber</th>
        <th>address</th>
    </tr>
    <tr>
        <td>${employee.employeeId}</td>
        <td>${employee.name}</td>
        <td>${employee.email}</td>
        <td>${employee.password}</td>
        <td>${employee.department}</td>
        <td>${employee.salary}</td>
        <td>${employee.phoneNumber}</td>
        <td>${employee.address}</td>
    </tr>
</table>
