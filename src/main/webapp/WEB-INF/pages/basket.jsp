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
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <form:form cssStyle="margin-top: 10px;" name = "clear" action="${contextPath}/basket/purchase" method="DELETE">
        <input  type="submit" class="btn btn-default" value="Perchase">
    </form:form>
    <form:form cssStyle="margin-top: 10px;" name = "clear" action="${contextPath}/basket/remove" method="DELETE">
        <input  type="submit" class="btn btn-danger" value="Clear">
    </form:form>
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
                <td><img class="group list-group-image" src="${product.productImage}" /></td>
                <td>${product.productName}</td>
                <td>${product.productPrice/100}${product.productPrice%100}</td>
                <td>
                    <form:form cssStyle="margin-top: 10px;" name = "removeProduct" action="${contextPath}/basket/remove/${product.id}" method="DELETE">
                        <input  type="submit" class="btn btn-danger" value="Delete">
                    </form:form>
                   </td>
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
