<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="java.util.List" %>
<%@ page import="SpringMVC.model.Good" %>

<html lang="en">
<head>
    <meta charset="UTF-8">

    <link type="text/css"
          rel="stylesheet"
          href="<c:url value="/resources/styles.css" />">
</head>
<body>

<div>
    <div class="container">

<%--@elvariable id="order" type="SpringMVC.view.Order"--%>
<form:form modelAttribute="order"
           method="POST"
           action="/order">
    <h1> Hello ${model.user.getName}! </h1>
    <button type="submit" id="submit"> Submit</button>
        </form:form>
<%--        <form name="order" action="/tab" method="post">--%>
<%--            <h1> Hello ${sessionScope.user.name}! </h1>--%>
<%--            <p id="makeYourOrder">Make your order</p>--%>
<%--            <input id="input_order" name="input_order"--%>
<%--                   hidden/> &lt;%&ndash;для передачи списка выбранных элементов в сервлет /tab - по кнопке на форме в request передаются только элементы input&ndash;%&gt;--%>
<%--            <select id="order" required>--%>
<%--                <%--%>
<%--                    List<Good> goodList = (List<Good>) request.getSession().getAttribute("goodList");--%>
<%--                    for (Good good : goodList) {--%>
<%--                        out.println("<option> " + good.getName() + "(" + good.getPrice() + "$ )</option>");--%>
<%--                    }--%>
<%--                %>--%>
<%--            </select>--%>
<%--            <br>--%>
<%--            <br>--%>

<%--            <button type="button" id="add_item"> Add item</button>--%>
<%--            <button type="submit" id="submit"> Submit</button>--%>
<%--        </form>--%>
    </div>
</div>
<%-- js работает только после прорисовки формы--%>
<%--<script src="/resources/jQuery.js"></script>--%>
<%--<script src="/resources/jScript.js"></script>--%>
</body>
</html>

