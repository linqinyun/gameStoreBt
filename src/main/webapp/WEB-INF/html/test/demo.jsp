<%--
  Created by IntelliJ IDEA.
  User: ZHR
  Date: 2022/5/24
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>this is test page</h1>
<h1>${test}</h1>
<c:forEach items="${list}" var="c">
    <h1>${c.name}</h1>
    <h1><fmt:formatDate value="${c.updateTime}" pattern="yyyy/MM/dd HH:mm:ss"/></h1>
</c:forEach>
</body>
</html>
