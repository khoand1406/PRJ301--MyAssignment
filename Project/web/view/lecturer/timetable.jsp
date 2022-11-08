<%-- 
    Document   : timetable
    Created on : Nov 7, 2022, 3:53:39 PM
    Author     : win
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="helper" class="util.DateTimeHelper"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Lecturer: <input type="text" readonly="readonly" value="${requestScope.lecturer.inname}">
        <form action="timetable" method="get">
            <input type="hidden" name= "lid" value="${param.lid}"><!-- comment -->
            From: <input type="date" name="from" value="${requestScope.from}"><!-- comment -->
            To: <input type="date" name="to" value="${requestScope.to}">   
            <input type="submit" value="View">
        </form>
            <table border="1px">
                <tr>
                    <td></td>
                    <c:forEach items="${requestScope.dates}" var="d">
                        <td>${d} <br/>${helper.getDayNameofWeek(d)}</td>
                        
                        
                    </c:forEach>
                </tr>
                <c:forEach items="${requestScope.slots}" var="slot">
                    <tr>
                        <td>${slot.description}</td>
                        <c:forEach items="${requestScope.dates}" var="d">
                            <td>
                                <c:forEach items="${requestScope.sessions}" var="ses">
                                    <c:if test="${helper.compare(ses.date, d) eq 0 or (ses.slot.tid eq slot.tid)}">
                                        <a href="lecturer/takeatt?id=${ses.id}">${ses.group.name}-${ses.group.course.cname}</a>
                                        <br/><!-- comment -->
                                        ${ses.room.rname}
                                        <c:if test="${ses.attended}">
                                            <img src="src" alt="alt"/>
                                        </c:if>
                                        <c:if test="${!ses.attended}">
                                            <img src="src" alt="alt"/>
                                        </c:if>    
                                    </c:if>
                                </c:forEach>
                            </td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
    </body>
</html>
