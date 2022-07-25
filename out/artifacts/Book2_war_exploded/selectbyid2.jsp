<%@ page import="com.bjpowernode.bean.Book" %><%--
  Created by IntelliJ IDEA.
  User: zhangzhixuan
  Date: 2022/7/18
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Book book = (Book) request.getAttribute("book");
%>
<%--这个是展示页面，根据id查询出来进行展示的--%>
    <table border="1px" align="center" width="700px">
        <form action="BookServlet?me=updateBook" method="post">
            <input type="hidden" name="id" value="${book.id}">
            <tr>
                <td>booknum</td>
                <td><input type="text" name="booknum" value="${book.booknum}"></td>
            </tr>
            <tr>
                <td>bookname</td>
                <td><input type="text" name="bookname" value="${book.bookname}"></td>
            </tr>
            <tr>
                <td>bookauthor</td>
                <td><input type="text" name="bookauthor" value="${book.bookauthor}"></td>
            </tr>
            <tr>
                <td>bookpublish</td>
                <td><input type="text" name="bookpublish" value="${book.bookpublish}"></td>
            </tr>
            <tr>
                <td>bookpublish</td>
                <td><input type="text" name="bookpublish" value="${book.bookpublish}"></td>
            </tr>
            <tr>
                <td>bookdate</td>
                <td><input type="text" name="bookdate" value="${book.bookdate}"></td>
            </tr>
            <tr>
                <td>bookprice</td>
                <td><input type="text" name="bookprice" value="${book.bookprice}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="修改"></td>
            </tr>
        </form>
    </table>
</body>
</html>
<%--<cc:forEach items="${requestScope.book}" var="ss"> 这个是对象，不是集合，没有办法遍历
            <tr>
                <td>${ss.booknum}</td>
                <td>${ss.bookname}</td>
                <td>${ss.bookauthor}</td>
                <td>${ss.bookpublish}</td>
                <td>${ss.bookdate}</td>
                <td>${ss.bookprice}</td>
            </tr>
        </cc:forEach>--%>