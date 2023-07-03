
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 style="color: darkmagenta" >  Employee list</h1>
<table border="2" cellspacing="0" cellpadding="8" style="border-color: darkblue" >
    <tr >
        <th>Employee Id</th>
        <th> name</th>
        <th> email</th>
        <th> password</th>
        <th> department</th>
        <th> salary</th>
        <th> phoneNumber</th>
        <th> address</th>

    </tr>
    <c:forEach items="${list}" var="list">
        <tr>
            <td><a href="getById/${list.employeeId}" > ${list.employeeId} </a></td>
                    <td>${list.name}</td>
                    <td>${list.email}</td>
                    <td>${list.password}</td>
                    <td>${list.department}</td>
                    <td>${list.salary}</td>
                    <td>${list.phoneNumber}</td>
                    <td>${list.address}</td>
            <td><a href="editEmployee/${list.employeeId}">update</a></td>
            <td><a href="deleteEmployee/${list.employeeId}">delete</a></td>
        </tr>
    </c:forEach>
</table><br><br>
<button>
<h1>
    <a href="http://localhost:8082/EmployeeClentSideProject_war_exploded/home">Home</a>
</h1>
</button>