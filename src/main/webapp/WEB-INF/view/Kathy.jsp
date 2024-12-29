<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>練習頁面</title>
    <link rel="stylesheet" href="/css/style.css" />
    <style>
        h3{
            color:chocolate
        }
    </style>
</head>
<body>
    <h1>This is the body of the index view for Kathy</h1>
    <p style="color:blue">${message}</p>
    <h2>${description}</h2>
    <h3>一切都是最好的安排</h3>
    <a target="_blank" href="https://www.google.com.tw">google頁面</a> //加入target會開啟新的頁面
    <a target="_blank" href="https://www.gtalent.com.tw/">大數智能</a>
    <img src="/images/image.jpg" alt="範例圖片" width="100px" height="auto"/>
    <form action="/model/register" method="post">
        <label for="name">姓名：</label>
        <input type="text" id="name" name="name" />
        <button type="submit">送出</button>
    </form>
</body>
</html>