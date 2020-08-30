<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
      function deleteConfirm(){
    	  conf = confirm("Are you sure you want to delete?");
    		if (conf)
    			return true
    		else
    			return false;
      }
      
      $(document).ready(function() {
    	    $('#dataTbl').DataTable( {
    	        "pagingType": "full_numbers"
    	    } );
    	} );
</script>
</head>
<body>
              <h1 >View Accounts</h1>
              <a href="addAccount" align="center">Create New Account</a><br><br>
        <table border="1" id = "dataTbl">
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
                               <a href="editAccount?id=${c.userId}">Edit</a> |
                               <c:if test="${c.switchDelete eq 'Y'}">
                               <i class="fas fa-trash-alt"><a href="deleteAccount?id=${c.userId}">Delete</a></i>
                               </c:if>
                               <c:if test="${c.switchDelete eq 'N'}">
                               <a href="activateAccount?id=${c.userId}">Activate</a>
                               </c:if>
                               </td>
                        </tr>
                        </c:forEach>
               </tbody>
        </table>
</body>
</html>