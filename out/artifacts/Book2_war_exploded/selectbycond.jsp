<%--
  Created by IntelliJ IDEA.
  User: zhangzhixuan
  Date: 2022/7/18
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--根据条件进行查询--%>

<%----%>
    <form action="BookServlet?me=selectByCond" method="post">
        booknum:<input type="text" name="booknum">
        bookname:<input type="text" name="bookname">
        bookauthor:<input type="text" name="bookauthor">
        bookpublish:<input type="text"name="bookpublish">
        bookdate:<input type="date" name="bookdate">
        bookprice:<input type="text" name="bookprice">
        <input type="submit" value="查询">
    </form>


</body>
</html>
