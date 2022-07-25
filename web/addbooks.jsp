<%--
  Created by IntelliJ IDEA.
  User: zhangzhixuan
  Date: 2022/7/18
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--添加书籍的jsp--%>
    <form action="BookServlet?me=addBook" method="post">
        书籍编号:<input type="text" name="booknum">
        书籍姓名:<input type="text" name="bookname">
        书籍作者:<input type="text" name="bookauthor">
        出版社:<input type="text" name="bookpublish">
        日期:<input type="date" name="bookdate">
        单价:<input type="text" name="bookprice">
        <input type="submit" value="提交">
    </form>
</body>
</html>
