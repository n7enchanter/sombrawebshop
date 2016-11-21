<%--
  Created by IntelliJ IDEA.
  User: Yuri
  Date: 05.11.2016
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <style>
        img{
            max-height: 200px;
            max-width: 60px;
        }
    </style>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Додаткові теми -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
</head>
<body>
<jsp:include page="header.jsp"/>

<div id="products" class="row list-group">
<c:forEach items="${products}" var="product">
    <div class="item  col-xs-4 col-lg-4" style="margin-left: 10px; max-width: 420px; ">
        <div class="thumbnail">
            <a href="${contextPath}/product/${product.id}">
            <img class="group list-group-image" src="${product.productImage}" />
            </a>
            <div class="caption">
                <h4 class="group inner list-group-item-heading">
                    ${product.productName}</h4>
                <p class="group inner list-group-item-text">
                ${product.productDescription}</p>
                <div class="row">
                    <div class="col-xs-12 col-md-6">
                    <p class="lead">${product.productPrice/100}${product.productPrice%100}</p>
                    </div>
                </div>
            </div>
            <c:if test="${not empty pageContext.request.userPrincipal}">
                <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                    <a class="btn btn-default " href="${contextPath}/admin/edit/${product.id}" >Edit</a>
                    <form:form cssStyle="margin-top: 10px;" name = "deleteProduct" action="${contextPath}/admin/delete/${product.id}" method="DELETE">
                        <input  type="submit" class="btn btn-default" value="Delete">
                    </form:form>
                </c:if>
                <form:form cssStyle="margin-top: 10px;" name = "buyProduct" action="${contextPath}/buy/${product.id}" method="PUT">
                    <input  type="submit" class="btn btn-default" value="Buy">
                </form:form>
                    <!--<a class="btn btn-default" href="${contextPath}/buy/${product.id}">Buy</a>-->
            </c:if>

        </div>
    </div>
</c:forEach>
</div>

<!--<script>
    function products() {
        var url = "/products";
        if($("input[id='search']").val()!=null){
            url+="?searchQuery="+$("input[id='search']").val();
        }
        $.ajax({
            url:url,
            dataType:"json",
            success:function (data) {

                $("div[id='products']").empty();
                for(var i=0;i<data.length;i++){
                    var form="<div class='item  col-xs-4 col-lg-4'>";
                    form +="<div class='thumbnail'>";
                    form +="<a src='/product/data[i].id'><img class='group list-group-image' src='"+ data[i].product_image+"' /></a>";
                    form +="<div class='caption'> <h4 class='group inner list-group-item-heading'>"
                            +data[i].product_name+ "</h4>";
                    form +="<p class='group inner list-group-item-text'>"
                            +data[i].product_description+"</p>";
                    form +="<div class='row'><div class='col-xs-12 col-md-6'><p class='lead'>"
                            +data[i].product_price+"</p></div>";
                    form +="</div></div></div></div>"
                    $("div[id='products']").append(form);
                }


            }


        })

    }
    /*$("input[id='search']").bind("change",products());*/
    $(document).ready(products());
</script>-->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>
