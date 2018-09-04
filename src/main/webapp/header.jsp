<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<div class="container-fluid">
    <div class="col-md-4">
    </div>
    <div class="col-md-5">

    </div>
    <div class="col-md-3" style="padding-top:20px">
        <ol class="list-inline">

            <%--  ${empty } --%>

            <c:if test="${empty sessionScope.activeuser}">
                <li><a href="login.jsp">登录</a></li>
                <li><a href="register.jsp">注册</a></li>
            </c:if>

            <c:if test="${!empty sessionScope.activeuser }">
                <li style="color:red">欢迎您，${sessionScope.activeuser.username}</li>
                <li><a href="${pageContext.request.contextPath }/logout">退出</a></li>
            </c:if>

            <li><a href="${pageContext.request.contextPath }/cartinfo">购物车</a></li>
            <li><a href="${pageContext.request.contextPath }/ordersshow?name=car">我的订单</a></li>
        </ol>
    </div>
</div>

<!-- 导航条 -->
<div class="container-fluid">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">首页</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <!-- 导航条 -->
                <ul class="nav navbar-nav" id="categoryUl">

                </ul>

                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">搜索</button>
                </form>
            </div>
        </div>

        <script type="text/javascript">
            $(function () {
                $.ajax({
                    type: "GET",
                    url: "showInfo",
                    dataType: "json",
                    success: function (results) {
                        $(results).each(function (index, item) {
                            var li = "<li><a href='${pageContext.request.contextPath}/getProBycId?cid="+item.cid+"'><font size='3' color='white'>" + item.cname + "</font></a></li>";
                            $("#categoryUl").append(li);
                        });
                    }

                });
            });
        </script>
    </nav>
</div>