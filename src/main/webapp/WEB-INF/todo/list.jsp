<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-23
  Time: 오후 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Todo List</title>
    <style>
        table {
            width: 80%;
            margin: 20px auto;
            border-collapse: collapse;
            font-family: "Segoe UI", Arial, sans-serif;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #4CAF50;
            color: white;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
            transition: 0.2s ease-in;
        }

        a {
            color: #2a7ae2;
            text-decoration: none;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }

        caption {
            caption-side: top;
            font-size: 1.3em;
            font-weight: bold;
            margin-bottom: 10px;
        }
    </style>

</head>
<body>
<h1>Todo List</h1>

<%--<ul>--%>
<%--    <c:forEach items="${dtoList}" var="dto">--%>
<%--        <li>--%>
<%--            <span><a href="/todo/read?tno=${dto.tno}">${dto.tno}</a></span>--%>
<%--            <span>${dto.title}</span>--%>
<%--            <span>${dto.dueDate}</span>--%>
<%--            <span>${dto.finished? "DONE": "NOT YET"}</span>--%>
<%--        </li>--%>
<%--    </c:forEach>--%>
<%--</ul>--%>



<table>
    <caption>Todo List</caption>
    <thead>
    <tr>
        <th>No</th>
        <th>Title</th>
        <th>Due Date</th>
        <th>Status</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${dtoList}" var="dto" varStatus="status">
        <tr>
            <!-- 자동 글번호 (1부터 시작) -->
            <td>${status.count}</td>

            <!-- 제목에 링크 걸기 -->
            <td>
                <a href="/todo/read?tno=${dto.tno}">${dto.title}</a>
            </td>

            <td>${dto.dueDate}</td>

            <td>
                <c:choose>
                    <c:when test="${dto.finished}">DONE</c:when>
                    <c:otherwise>NOT YET</c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>


</body>
</html>