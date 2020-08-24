<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <h2>Unlock Account Here</h2>
        <form:form action="#" modelAttribute="unlockAcc" method="POST">
                 <table>
                       <tr>
                            <th>Your Email :</th>
                            <td>${email}</td>
                       </tr>
                       <tr>
                           <td>Enter Temporary Password :</td>
                           <td><form:input path="tempPwd"/></td>
                       </tr>
                       <tr>
                            <td>Enter New Password :</td>
                            <td><form:input path="newPwd"/></td>
                       </tr>
                       <tr>
                            <td>Confirm New Password :</td>
                            <td><form:input path="confirmPwd"/></td>
                       </tr>
                       <tr>
                           <td></td>
                           <td><input type="submit" value="unlock"></td>
                       </tr>
                 </table>
        </form:form>
</body>
</html>