<%-- 
    Document   : view
    Created on : Oct 14, 2022, 10:39:39 AM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Attend</title>
        
    </head>
    <body>
        <table border="1px">
            <tr>
                <td>StudentID</td>
                <td>StudentName</td>
                <td>Gender</td>
                <td>Image</td>
                <td>Status</td>
                <td>Recordtime</td>
                
            </tr>
            <c:forEach items="${requestScope.students}" var="s">
                <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.gender}</td>
                <td><img src="${s.image}" width="100px" ></td>
                <td>${s.attend.status}</td>
                <td>${s.attend.recordtime}</td>
               
            </tr>
            </c:forEach>
        </table>
       
    </body>
</html>

