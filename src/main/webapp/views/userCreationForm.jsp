<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
             <h1>Create Account</h1>
             <form:form action="userAccReg" modelAttribute="userAcc" method="POST">
                   <table>
                          <tr>
                               <th>First Name :</th>
                               <td>
                                     <form:hidden path="userId"/>
                                    <form:input path="firstName"/>
                               </td>
                          </tr>
                          <tr>
                                <th>Last Name :</th>
                                <td>
                                     <form:input path="lastName"/>
                                </td>
                          </tr>
                          <tr>
                               <th>Email :</th>
                               <td>
                                 <form:input path="email"/>
                               </td>
                          </tr>
                          <tr>
                               <th>Gender :</th>
                               <td>
                                   Male:<form:radiobutton path="gender" value="M" id="gen"/>
                                   Female:<form:radiobutton path="gender" value="F" id="gen" />
                               </td>
                          </tr>
                          <tr>
                              <th>Role :</th>
                              <td>
                                    <form:select path="roleId">
                                         <form:option value="">-Select-</form:option>
                                         <form:options items="${roleMap}"/>
                                    </form:select>
                              </td>
                          </tr>
                          <tr>
                               <th></th>
                               <td>
                                    <input type="submit" value="Create" /><input type="submit" value="Update" formaction="updateAccount">
                               </td>
                          </tr>
                   </table>
             </form:form>
             
             <a href="viewAccounts">View Accounts</a> 
             
</body>
</html>