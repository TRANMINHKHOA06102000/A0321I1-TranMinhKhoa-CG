<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List student by JSTL</title>
</head>
<body>
<h2>List student by JSTL</h2>
<table>
    <tr>
        <th>NO</th>
        <th>ID</th>
        <th>Name</th>
        <th>Date Of Birth</th>
        <th>Gender</th>
        <th>Degree</th>
    </tr>
    <c:forEach var="student" items="${studentListServlet}" varStatus="loop">
        <tr>
<%--            count đếm từ 1--%>
<%--            index đếm từ 0--%>

            <td>${loop.count}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.dateOfBirth}</td>
            <td>
                <c:if test="${student.gender==1}">Male</c:if>
                <c:if test="${student.gender==0}">Female</c:if>
            </td>
            <td>
                <c:choose>
                    <c:when test="${student.grade<4}">Bad</c:when>
                    <c:when test="${student.grade<7}">Good</c:when>
                    <c:otherwise>Very good</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
