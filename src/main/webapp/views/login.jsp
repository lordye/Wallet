<%--
  Created by IntelliJ IDEA.
  User: yedy25376
  Date: 2018/9/28
  Time: 15:15
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
    <title>登录页面</title>
    <!-- Bootstrap -->
    <link href="<c:url value="/css/bootstrap.min.css" />" rel="stylesheet">
    <style type="text/css">
        #top_1{
            background-color: black;
            height: 20%;
        }
        #main_2 {
            width: 100%;
            height: 80%;
            background: #DDB263 repeat-x;
        }
        #middle_main{
            position: absolute;
            top: 0px;
            left: 0;
            right: 0;
            margin: auto;
            width: 1366px;
            height: 100%;
        }
        #middle_1{
            height: 20%;
            width: 100%;
        }
        #middle_2{
            height: 80%;
            width: 100%;
            border: 1px solid #DDB263;
            background: url("<c:url value="/images/8.jpg" />");
            background-size: 100% 100%;
        }
        #login_input{
            width: 60%;
            height: 60%;
            margin: 80px 0px 0px 50px;
        }
        .input_style{
            margin-left:460px;
            width: 200px;
            height:40px;
            display: none
        }

    </style>
</head>
<body>
<div style="position: relative">
    <div id="top_1">
    </div>
    <div id="main_2">

    </div>
    <div id="middle_main">
        <div id="middle_1">
            <div class="container">
                <h1 style="color: white; font-size: 50px"><span style="color: white; font-size: 60px">U</span> 钱包</h1>
                <p style="color: white; font-size: 20px;">你的理财专家，快捷支付，安全支付，乐享生活。</p>
            </div>
        </div>
        <div id="middle_2">
            <div id="login_input">
                <div style="text-align: center; margin:20px 250px 20px 0px">
                    <h1>欢迎登录</h1>
                </div>

                <form class="form-horizontal" action="/login" method="post">
                    <div class="form-group" style="margin-bottom: 20px; height: 60px">
                        <label for="exampleInputEmail3" class="col-sm-2 control-label">用户名：</label>
                        <div class="col-sm-10" style="width: 350px">
                            <input style="width: 300px; height: 40px;" type="email" class="form-control" id="exampleInputEmail3" placeholder="用户名">
                        </div>
                        <div class="input_style alert alert-info" role="alert">正确</div>
                        <div class="input_style alert alert-success" role="alert">正确</div>
                        <div class="input_style alert alert-danger" role="alert">用户名错误</div>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword3" class="col-sm-2 control-label">密码：</label>
                        <div class="col-sm-10"  style="width: 350px">
                            <input style="width: 300px; height: 40px;" type="password" class="form-control" id="exampleInputPassword3" placeholder="密码">
                        </div>
                        <div class="input_style alert alert-info" role="alert">正确</div>
                        <div class="input_style alert alert-success" role="alert">正确</div>
                        <div class="input_style alert alert-danger" role="alert">用户名错误</div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10" style=" width: 315px">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox">记住我
                                </label>
                                <a style="float:right">忘记密码?</a>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" style="width: 300px;margin-bottom: 20px;">登录</button>
                        </div>
                        <div class="col-sm-offset-2 col-sm-10">
                            <button type="submit" class="btn btn-default" style="width: 300px">注册</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>