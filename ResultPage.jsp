<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Генератор мудрых цитат</title>
    <link href="https://fonts.google.com/share?selection.family=Reem%20Kufi"
          rel="stylesheet">
    <link rel="stylesheet" href="static/CSS/QuotePage.css">
    <link rel="stylesheet" href="static/CSS/Page.css">
</head>
<body>
<header>
    <div class="hat">
        <img src="static/IMG/Hat.jpg" alt="Hat">
        <h1>Генератор мудрых цитат</h1>
    </div>
    <%
        String quote = (String) request.getAttribute("quote");
    %>
    <div class="receiveQuote">
        <p>
            <%=quote%>
        </p>
    </div>
    <form action="${pageContext.request.contextPath}/quote" method="get" class="formBtnQuote">
        <input type="submit" value="Получить цитату" class="btn">
    </form>
</header>
</body>
</html>
