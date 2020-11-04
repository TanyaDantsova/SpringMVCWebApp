<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TabForm</title>
    <link type="text/css"
          rel="stylesheet"
          href="<c:url value="/resources/styles.css" />">
</head>
<body>
<div>
    <div class="container">
        <form>
            <h2>Dear ${sessionScope.user.name}, your order:
            </h2>
            <label>
                <%
                    Map<String, Integer> orderMap = (Map<String, Integer>) request.getAttribute("order");
                    for (Map.Entry<String, Integer> pair : orderMap.entrySet()) {
                        out.println(pair.getKey() + "   x" + pair.getValue() + "</br>");
                    }
                %>
            </label>
            <h4> Total: ${requestScope.total}
            </h4>
        </form>
    </div>
</div>
</body>
</html>
