<%-- 
    Document   : takeatt
    Created on : Nov 3, 2022, 10:57:03 PM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        ${requestScope.ses.id}, class: ${requestScope.ses.group.name}
        <br/><!-- comment -->
        Subject: ${requestScope.ses.group.course.cname}
        Room: ${requestScope.ses.room.rname}
        Time: ${requestScope.ses.date}
        ${requestScope.ses.slot.description}
        <br/>
        Attended: ${requestScope.ses.attended?"Yes":"No"}
        <form action="takeatt" method="post">
            <input type="hidden" name="sesid" value="${param.id}"><!-- comment -->
            <table border="1px">
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Present</th>
                    <th>Absent</th>
                    <th>Description</th>
                </tr>
                <c:forEach items="${requestScope.atts}" var="a">
                    <tr>
                        <td>${a.student.id}</td>
                    <input type="hidden" value="${a.student.id}" name="stdid">
                    <td>${a.student.name}</td>
                    <td><input type="radio" 
                               <c:if test="${a.status}"> 
                                   checked="checked"
                               </c:if> name="present${a.student.id}" value="present">
                    </td>
                    <td><input type="radio" 
                               <c:if test="${!a.status}">
                                   checked="checked"
                               </c:if>
                                   name="present${a.student.id}" value="absent" ><br/> 
                               </td>
                               <td><input type="" value="${a.description}" name="description${a.student.id}"></td>           
                    </tr>
                </c:forEach>
            </table>
            <input type="submit" value="Save">

        </form>
    </body>
</html>
