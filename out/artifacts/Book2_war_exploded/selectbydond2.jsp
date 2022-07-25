<%--
  Created by IntelliJ IDEA.
  User: zhangzhixuan
  Date: 2022/7/18
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--这是根据条件进行查询的页面--%>
    <table border="1px" align="center">
        <tr>
            <td>booknum</td>
            <td>bookname</td>
            <td>bookauthor</td>
            <td>bookpublish</td>
            <td>bookdate</td>
            <td>bookprice</td>
        </tr>
        <c:forEach items="${requestScope.books}" var="ss">
            <tr>
                <td>${ss.booknum}</td>
                <td>${ss.bookname}</td>
                <td>${ss.bookauthor}</td>
                <td>${ss.bookpublish}</td>
                <td>${ss.bookdate}</td>
                <td>${ss.bookprice}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
