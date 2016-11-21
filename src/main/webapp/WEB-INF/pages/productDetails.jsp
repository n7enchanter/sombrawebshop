<%--
  Created by IntelliJ IDEA.
  User: Yuri
  Date: 05.11.2016
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
    <style>
        img{
            max-height: 400px;
            max-width: 300px;
        }
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>


<div class="item-container">
    <h1 style="margin-left: 20px;">${product.productName}</h1>
    <div class="container">
        <div class="col-md-12">
            <div class="product col-md-3 service-image-left">

                <img id="item-display" src="${product.productImage}" />

            </div>


        </div>

        <div class="col-md-7">
            <div class="product-desc">${product.productDescription}</div>

            <hr>
            <div class="product-price"> ${product.productPrice}</div>
            <hr>
            <div class="btn-group cart">
                <c:if test="${not empty pageContext.request.userPrincipal}">
                    <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                        <a style="margin-bottom: 10px;" class="btn btn-default " href="${contextPath}/admin/edit/${product.id}" >Edit</a>
                        <form:form cssStyle="margin-top: 10px;" name = "deleteProduct" action="${contextPath}/admin/delete/${product.id}" method="DELETE">
                            <input  type="submit" class="btn btn-default" value="Delete">
                        </form:form>
                    </c:if>
                    <form:form cssStyle="margin-top: 10px;" name = "buyProduct" action="${contextPath}/buy/${product.id}" method="PUT">
                        <input  type="submit" class="btn btn-default" value="Buy">
                    </form:form>
                       <!-- <a class="btn btn-default" href="${contextPath}/buy/${product.id}"  >Buy</a>-->
                </c:if>
            </div>

        </div>
    </div>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
