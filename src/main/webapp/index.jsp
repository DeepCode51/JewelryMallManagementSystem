<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
<%--    <meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>踏雪之莹</title>
    <link rel="stylesheet" href="CSS/test.css">
    <link rel="icon" href="img/default.ico" type="image/x-icon">
</head>
<body>
<div class="pro">
    <video id="v1" autoplay muted loop style="width: 100%">

        <source  src="vido/1.mp4">

    </video>
    <div class="login">
        <h1 style="margin-top: 35px;">欢迎登录</h1>
        <form action=""method="post">
            <table class="tab">
                <tr>
                    <td></td><td><div class="in1"><input class="username" name="username"type="text"placeholder="账号"></div></td>
                </tr>
                <tr>
                    <td></td><td><div class="in2"><input class="userpass"name="userpass" type="password"placeholder="密码"></div></td>
                </tr>
            </table>
            <input class="btn" type="submit"value="立即登陆">

        </form>
    </div>
</div>
</body>
</html>