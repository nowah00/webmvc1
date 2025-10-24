<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hawon
  Date: 2025. 10. 24.
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<c:if test="${param.result == 'error'}">
    <h2>로그인 에러</h2>
</c:if>
<form action="/login" method="post">
  <input type="text" name="mid" autocomplete="off">
  <input type="password" name="mpw" autocomplete="off">
  <button type="submit">LOGIN</button>
</form>
</body>
</html>
