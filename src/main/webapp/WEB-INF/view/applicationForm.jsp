
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<body bgcolor="#a9a9a9">
<style>
    .error{color:red}
</style>
<H2 style="color: blue" > Enter Employee Details : </H2>
<form:form action="saveData" modelAttribute="employeeForm" method="post">
    employeeId :<input name="employeeId" readonly  value="${employeeForm.employeeId}"/><br><br>
    name: <form:input path="name"/>
    <form:errors path="name" cssClass="error"/> <br><br>
    employee email: <form:input path="email"/>
    <form:errors path="email" cssClass="error"/> <br><br>
    employee password: <form:input path="password"/>
    <form:errors path="password" cssClass="error"/> <br><br>
    employee department: <form:input path="department"/>
    <form:errors path="department" cssClass="error"/> <br><br>
    employee salary: <form:input path="salary"/>
    <form:errors path="salary" cssClass="error"/> <br><br>
    employee phoneNumber : <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber" cssClass="error"/> <br><br>
    employee address: <form:input path="address"/>
    <form:errors path="address" cssClass="error"/> <br><br>

    <input type="submit" value="submit">
</form:form>
<h3><a href="viewEmployeeList">click to display All</a></h3>
<h3><a href="form" > Back</a> </h3>

</body>
</html>


