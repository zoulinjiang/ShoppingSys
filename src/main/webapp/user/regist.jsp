<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <%@include file="/common/head.jsp"%>
    <script type="text/javascript" src="../script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            //给按钮绑定事件
            $("#sub").click(function () {
                //对用户名进行限制
                //获取文本框信息
                var usernameText=$("#username").val();
                //创建正则表达式对象
                var usernamePatt=/^\w{5,12}$/
                //进行test验证
                if(!(usernamePatt).test(usernameText)){
                    $(".error_msg").text("用户名不合法！")
                    return false;
                }

                //验证密码
                var passwordText=$("#password").val();
                var passwordPatt=/^\w{5,12}$/;
                if(!passwordPatt.test(passwordText)){
                    $(".error_msg").text("密码输入不合法！");
                    return false;
                }
                //对密码进行验证
                var repwdText=$("#repwd").val();
                if(repwdText!=passwordText){
                    $(".error_msg").text("两次密码输入不一致！");
                    return false;
                }

                //验证邮箱
                var emailText=$("#email").val();
                var emailPatt=/^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
                if(!emailPatt.test(emailText)){
                    $(".error_msg").text("邮箱格式不合法！");
                    return false;
                }

                var codeText=$("#code").val();
                codeText = $.trim(codeText);
                if(codeText==null||codeText==""){
                    $(".error_msg").text("验证码不能为空！");
                    return false;
                }

                $(".error_msg").text("");
            });
        })
    </script>
</head>
<body>
<div style="text-align: center;font-size: 18px;">

    <div class="lll">
        <span style="color:cornflowerblue;font-size: 25px">欢迎注册</span>
        <br><br>
    </div>
    <div>
        <span class="error_msg" style="color: crimson;font-family: 仿宋">
                ${empty requestScope.msg ?"请进行注册":requestScope.msg}
        </span>
        <div>
            <form action="userServlet" method="post">
                <input type="hidden" name="action" value="regist">
                    <lable>用户名称：</lable>
                    <input type="text" name="username" id="username">
                <br/>
                <br/>
                    <lable>用户密码：</lable>
                    <input type="password" name="password" id="password">
                <br/>
                <br/>
                    <lable>确认密码：</lable>
                    <input type="password" name="repwd" id="repwd">
                <br/>
                <br/>
                    <label>电子邮箱：</label>
                    <input type="text" name="email" id="email">
                <br><br>
                    <label>验&nbsp;证&nbsp;码&nbsp;：</label>
                    <input type="text" name="code" id="code" style="width: 75px">
                <img src="../img/code.bmp">
                <br><br>
                    <input type="radio" name="isCus" value="0" >商家
                    <input type="radio" name="isCus" value="1"  checked="checked">用户
                <br><br>
                    <input type="submit" id="sub" value="注&nbsp;&nbsp;册"
                       style="width: 150px;height: 30px;">
            </form>
        </div>
    </div>
</div>
</body>
</html>