<%--
  Created by IntelliJ IDEA.
  User: Yuri
  Date: 04.11.2016
  Time: 13:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<nav class="navbar navbar-default navbar-static-top">
    <div class="container">
        <div class="navbar-header">
            <a href="${contextPath}/product" class="navbar-brand">SombraTestShop</a>
        </div>
        <ul class="nav navbar-nav" >
            <li> <a class="button-bar" href="${contextPath}/product">Головна</a></li>
            <c:if test="${not empty pageContext.request.userPrincipal}">
                <li role="presentation"><a href="${contextPath}/basket"> Корзина<span class="badge" style="background:#d9534f">20</span></a></li>
            </c:if>
            <c:if test="${not empty pageContext.request.userPrincipal}">
                <c:if test="${pageContext.request.isUserInRole('ROLE_ADMIN')}">
                    <li> <a class="button-bar" href="${contextPath}/admin">Адміністрація</a></li>
                </c:if>
            </c:if>
               <!-- <input type="text" name="search" id="search" placeholder="Search"/>-->

        </ul>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <form id="logoutForm" method="POST" action="${contextPath}/logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
            <div class="navbar-header" >
                <li>Welcome ${pageContext.request.userPrincipal.name}</li>
            </div>
            <a class="btn btn-danger navbar-btn navbar-right"onclick="document.forms['logoutForm'].submit()">Logout</a>
        </c:if>
        <c:if test="${pageContext.request.userPrincipal.name == null}">
            <a class="btn btn-default navbar-btn navbar-right" style="margin-left:10px;" href="${contextPath}/registration" >Register</a>
            <button class="btn btn-primary navbar-btn navbar-right" data-toggle="modal" data-target="#login" >Login</button>
        </c:if>
    </div>
</nav>
<div class="modal" id="login">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button class="close" type="button" data-dismiss="modal">x</button>

                <h2 class="modal-title">Login  Form</h2></div>
            <div class="modal-body">
                <form  method="POST" action="${contextPath}/login" class="form=signin">
                    <div class="form-group">
                        <label for="username" class="sr-only">Username</label>
                        <input class="form-control" name="username" type="text" id="username" placeholder="Username"/>
                    </div>

                    <div class="form-group">
                        <label for="password" class="sr-only">Password</label>
                        <input class="form-control" name="password" type="password" id="password" placeholder="Password"/>
                    </div>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <button class="btn btn-lg btn-primary btn-block" type="submit" >Log In</button>


                </form>

            </div>
        </div>
    </div>
</div>
<script src="//ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

