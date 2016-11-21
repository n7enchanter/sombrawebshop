<%--
  Created by IntelliJ IDEA.
  User: Yuri
  Date: 31.10.2016
  Time: 11:19
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
    <!-- Свіжа збірка мінімізованих CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

    <!-- Додаткові теми -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

</head>
<body>
<jsp:include page="header.jsp"/>
    <div role="tabpanel">
        <nav class="navbar navbar-default">
            <div class="container">
                <ul class="nav nav-pills nav-justified" role="tablist">
                    <li role="presentation" class="active"><a href="#productadd" aria-controls="productadd" role="tab" data-toggle="tab">Товари</a></li>
                    <li role="presentation"><a href="#userred" aria-controls="userred" role="tab" data-toggle="tab">Користувачі</a></li>
                </ul>



            </div>
        </nav>
        <div class="row tab-content">

            <div  class="col-xs-12 tab-pane fade in active" id="productadd">
                <div class="container">
                    <div class="container" name="image-div">

                    </div>
                    <form:form method="post" action="${contextPath}/admin/product/add" commandName="product">
                        <div class="form-group">
                            <c:if test="${!empty product.productName}">
                                <form:label path="id"><spring:message text="ID"/></form:label>
                                <form:input path="id" readonly="true" size="8" disabled="true"/>
                                <form:hidden path="id"/>
                            </c:if>
                        </div>
                        <div class="form-group">
                            <form:label path="productImage" class="sr-only">
                                <spring:message text="Image"/>
                            </form:label>
                            <form:input id="load" class="form-control" path="productImage"/>
                        </div>
                        <div class="form-group">
                            <form:label path="productName" class="sr-only">
                                <spring:message text="Name"/>
                            </form:label>
                            <form:input class="form-control" path="productName"/>
                        </div>
                        <div class="form-group">
                            <form:label path="productPrice" class="sr-only">
                                <spring:message text="Price"/>
                            </form:label>
                            <form:input class="form-control" path="productPrice"/>
                        </div>
                        <div class="form-group">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <form:label path="productDescription" class="sr-only">
                                <spring:message text="Description"/>
                            </form:label>
                            <form:textarea class="form-control" path="productDescription" rows="3"/>
                        </div>
                        <c:if test="${!empty product.productName}">
                            <input type="submit" class="btn btn-primary"
                                   value="<spring:message text="Edit Product"/>"/>
                        </c:if>
                        <c:if test="${empty product.productName}">
                            <input type="submit" class="btn btn-primary"
                                   value="<spring:message text="Add Product"/>"/>
                        </c:if>

                    </form:form>
                </div>
            </div>
            <div  class="col-xs-12 tab-pane fade" id="userred">
                <h1>Users</h1>

                <table class="table">
                    <thead>
                        <tr>
                            <th>Username</th>
                            <th>Email</th>
                            <th>Role</th>

                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${users}" var="user">
                            <c:if test="${user.role!='ROLE_ADMIN'}">
                            <tr>
                                <td>${user.username}</td>
                                <td>${user.email}</td>
                                <td>${user.role.name}</td>
                            </tr>
                            </c:if>
                        </c:forEach>

                    </tbody>
                </table>
            </div>

        </div>
    </div>
<!-- Свіжа збірка мінімізованої JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script>
    $("#load").bind("change",function () {
        var link = $("#load").val();
        $("div[name='image-div']").empty();
        if (link != null){
            $("div[name='image-div']").append($("<img class='group list-group-image' style=' max-width:400px; max-height:600px; ' src='" +link+"' >"));
    }

    });
    $(document).ready(function () {
        var link = $("#load").val();
        $("div[name='image-div']").empty();
        if (link != null) {
            $("div[name='image-div']").append($("<img class='group list-group-image' style=' max-width:400px; max-height:600px; ' src='" + link + "' >"));
        }
    });
</script>
<!--<script>
    $(document).ready(function () {
        $.ajax({
            url: "/admin/addproduct",
            type: "GET",
            dataType: "json",
            success: function (data) {
                $("select[name='category']").empty();
                for(var id=0; id<data.length;id++) {
                    $("select[name='category']").append($("<option value='" + data[id].id + "'>" + data[id].category_name + "</option>"));
                }
            }




        });
    });
</script>
<script>
    $(document).ready(function () {
        $.ajax({
            url: "/admin/userred",
            type:"GET",
            dataType:"json",
            success:function (data) {
                $("table[name='userred']").empty();
                for(var i =0 ; i< data.length;i++){
                    var form = "<tr>";
                    form+="<td>" + data[i].id + "</td>";
                    form+="<td>" + data[i].username + "</td>";
                    form+="<td>" + data[i].email + "</td>";
                    form+="<td>";
                    for(j in data[i].roles){
                    form+= data[i].roles[j].name +"|";
                    }
                    form+="</td>";
                    form+="<td><button type='button' class='btn btn-danger' name='{data[i].id]'id='delete-user'>Delete</button></td> "
                    $("table[name='userred']").append($(form));
                }
            }
        })
    })
</script>-->
</body>

</body>
</html>
