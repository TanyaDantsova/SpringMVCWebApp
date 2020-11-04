<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css"
          rel="stylesheet"
          href="<c:url value="/resources/styles.css" />">
    <title>Error page</title>
</head>
<body>
<div>
    <div class="container">
            <h2> Opps! </h2><br><br>
            <label>You shouldn't be here</label><br>
            <label>Please, agree with the terms of service first.</label><br>
            <p><a href="${pageContext.request.contextPath}/">Start page</a></p>
    </div>
</div>
</body>
</html>
