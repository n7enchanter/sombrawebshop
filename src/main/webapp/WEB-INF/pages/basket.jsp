<%--
  Created by IntelliJ IDEA.
  User: Yuri
  Date: 06.11.2016
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Корзина</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Додаткові теми -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<style>
    img{
        max-height: 600px;
        max-width: 400px;
    }
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div  class="col-xs-12">
    <a class="btn btn-default" href="${contextPath}/basket/purchase">Perchase</a>
    <a class="btn btn-danger" href="${contextPath}/basket/remove">Clear</a>
    <table class="table">

        <thead>
            <tr>
                <th>ID</th>
                <th>Product</th>
                <th>Name</th>
                <th>Prise</th>
                <th>Delete</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td><img class="group list-group-image" src="${product.product_image}" /></td>
                <td>${product.product_name}</td>
                <td>${product.product_price/100}${product.product_price%100}</td>
                <td><a  class="btn btn-danger" href="${contextPath}/basket/remove/${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
            <tr>
                <th></th>
            </tr>
        </tbody>
    </table>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
</body>
</html>
