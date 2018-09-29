<%--
  Created by IntelliJ IDEA.
  User: yedy25376
  Date: 2018/9/29
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--解析EL表达式--%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册页面</title>
    <!-- Bootstrap -->
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
</head>
<body>
<div class="jumbotron">
    <div style="width: 1366px; margin: auto;text-align: center">
        <h1>欢迎注册U钱包</h1>
    </div>
</div>
<div style="width: 1000px; margin: auto;text-align: center">
    <form class="form-horizontal">
        <div class="form-group"  style="width: 500px; margin:15px auto; ">
            <label for="inputEmail3" class="col-sm-2 control-label">用户名:</label>
            <div class="col-sm-10">
                <input style="width: 300px;" type="email" class="form-control" id="inputEmail3" placeholder="请输入用户名">
            </div>
        </div>
        <div class="form-group" style="width: 500px; margin:15px auto; ">
            <label for="inputPassword3" class="col-sm-2 control-label">密码:</label>
            <div class="col-sm-10">
                <input style="width: 300px;" type="password" class="form-control" id="inputPassword3" placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group" style="width: 500px; margin:15px auto; ">
            <label for="inputPassword2"  class="col-sm-2 control-label" style="white-space: nowrap">确认密码:</label>
            <div class="col-sm-10">
                <input style="width: 300px;" type="password" class="form-control" id="inputPassword2" placeholder="请确认密码">
            </div>
        </div>
        <div class="form-group"  style="width: 500px; margin:15px auto; ">
            <label for="inputEmail1" class="col-sm-2 control-label">手机号:</label>
            <div class="col-sm-10">
                <input style="width: 300px;" type="email" class="form-control" id="inputEmail1" placeholder="请输入手机号">
            </div>
        </div>
        <div class="form-group"  style="width: 500px; margin:15px auto; ">
            <label for="inputEmail4" class="col-sm-2 control-label">验证码:</label>
            <div class="col-sm-10" >
                <input style="width: 200px; display: inline;float:left" type="email" class="form-control" id="inputEmail4" placeholder="请输入6位手机验证码">
                <button class="btn btn-default" type="submit" style="display:inline;float:left">获取验证码</button>
            </div>
        </div>
        <div class="form-group"  style="width: 500px; margin:15px auto; ">
            <label for="inputEmail2" class="col-sm-2 control-label">邮箱:</label>
            <div class="col-sm-10">
                <input style="width: 300px;" type="email" class="form-control" id="inputEmail2" placeholder="请输入邮箱">
            </div>
        </div>
        <div class="form-group"   style="width: 500px; margin:15px auto; text-align:left">
            <div class="col-sm-offset-2 col-sm-10">
                <div class="checkbox">
                    <label>
                        <input type="checkbox"> 我已经阅读注册许可协议
                    </label>
                </div>
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10" style="margin-left: 80px">
                <button type="submit" class="btn btn-default" style="width: 300px; margin-left: 0px">注册</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
