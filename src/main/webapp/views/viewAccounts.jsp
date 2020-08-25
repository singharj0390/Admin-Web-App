<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
        <table border="1">
               <thead>
                      <tr>
                            <th>S.No.</th>
                            <th>Name</th>
                            <th>Email</th>
                            <th>Action</th>
                      </tr>
               </thead>
               <tbody>
                        <c:forEach items="${accounts}" var="c" varStatus="index">
                        <tr>
                               <td>${index.count}</td>
                               <td>${c.firstName}</td>
                               <td>${c.email}</td>
                               <td>
                               <a href="">Edit</a> |
                               <a href="">Delete</a>
                               </td>
                        </tr>
                        </c:forEach>
               </tbody>
        </table>
</body>
</html>