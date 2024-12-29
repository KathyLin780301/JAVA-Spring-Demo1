<%@ page contentType="text/html; charset=UTF-8" %>
<html>
    <head>
        <title>JavaScript 資料型別示例</title>
        <script>
              function showFruits() {
            let fruits = ["蘋果", "香蕉", "櫻桃"];
            let list = "";
            for (let i = 0; i < fruits.length; i++) {
                list += `<li>${"${fruits[i]}"}</li>`;
            }
            document.getElementById("fruitList").innerHTML = list;
        }
        </script>
    </head>
    <body>
        <button onclick="showFruits()">顯示水果</button>
        <ul id="fruitList">
            <li>芭樂</li>
            <li>西瓜</li>
            <li>榴槤</li>
        </ul>
    </body>
</html>