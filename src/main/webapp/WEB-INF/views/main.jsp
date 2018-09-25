<%--
  Created by IntelliJ IDEA.
  User: 45193
  Date: 2018/9/15
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html >
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Demo</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="dashboard.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Demo</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a>${loginUser.username}，你好！</a></li>
                <li><a href="/mine.do?id=${loginUser.id}">个人中心</a></li>
                <li><a href="/transfer/transferInfo.do?id=${loginUser.id}">转账记录</a></li>
                <li><a href="/signOut.do">退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="container">
            <h2 class="sub-header">Section title</h2>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th></th>
                        <th>#</th>
                        <th>编号</th>
                        <th>用户名</th>
                        <th>操作</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${list}" var="user" varStatus="i">
                    <tr>
                        <td></td>
                        <c:choose>
                            <c:when test="${loginUser.id == user.id}">
                               <td>√</td>
                                <td><c:out value="${i.count}"/></td>
                                <td><c:out value="${user.username}"/></td>
                                <td><a>转账</a></td>
                                <td><a href="/mine.do?id=${loginUser.id}">详情</a> </td>
                            </c:when>
                            <c:otherwise>
                                <td></td>
                                <td><c:out value="${i.count}"/></td>
                                <td><c:out value="${user.username}"/></td>
                                <td><a href="/transfer/balance.do?id=${user.id}">转账</a></td>
                                <td><a href="/checkPassword.do?id=${user.id}">详情</a> </td>
                            </c:otherwise>
                        </c:choose>
                        <%--<td>--%>
                            <%--<p class="navbar-text navbar-left">--%>
                                <%--<a class="navbar-link" data-toggle="modal" data-target="#myModal" style="color: #4cae4c">详情</a>--%>
                            <%--</p>--%>
                        <%--</td>--%>
                    </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
<!-- Modal -->
<%--<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">--%>
    <%--<div class="modal-dialog" role="document">--%>
        <%--<div class="modal-content">--%>

            <%--<div class="modal-header">--%>
                <%--<h4 class="modal-title" id="myModalLabel">验证密码</h4>--%>
            <%--</div>--%>

            <%--<div class="modal-body">--%>
                <%--<form class="form-signin" action="/login.do" method="post">--%>
                    <%--<label for="inputPassword" class="sr-only">Password</label>--%>
                    <%--<input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>--%>
                    <%--<br/>--%>
                    <%--<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>--%>
                <%--</form>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="../../assets/js/vendor/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
