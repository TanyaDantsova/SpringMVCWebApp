<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css"
          rel="stylesheet"
          href="<c:url value="/resources/styles.css" />">
    <title>Online Shop</title>
</head>

<body>
<div>
    <div class="container">
        <%--@elvariable id="user" type="SpringMVC.view.Registration"--%>
        <form:form modelAttribute="user"
                   method="POST"
                   action="/online-shop/order">

            <h2>Welcome to Online Shop</h2>
            <br><br>
            <input type="text" name="userName" placeholder="Enter your name"/>
            <br><br>
            <input type="checkbox" name="checkbox"/>I agree with the terms of service
            <br><br>
            <button type="submit">Enter</button>
        </form:form>
    </div>
</div>
</body>
</html>