<%--
  Created by IntelliJ IDEA.
  User: zhangzhixuan
  Date: 2022/7/18
  Time: 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<%--查询全部--%>
    <table border="1px" align="center" width="700px">
        <tr>
            <td>booknum</td>
            <td>bookname</td>
            <td>bookauthor</td>
            <td>bookpublish</td>
            <td>bookdate</td>
            <td>bookprice</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${requestScope.books}" var="s">
        <tr>
            <td>${s.booknum}</td>
            <td>${s.bookname}</td>
            <td>${s.bookauthor}</td>
            <td>${s.bookpublish}</td>
            <td>${s.bookdate}</td>
            <td>${s.bookprice}</td>
            <td><a href="BookServlet?me=preUpdate&id=${s.id}">更新</a></td>
            <td><a href="javascript:fun1(${s.id})">删除</a></td>
<%-- 更新操作应该是，点击这个超链接之后，书写get方法，进行条件查询，查询出来回显到jsp上，然后根据用户修改的东西进行提交           --%>
<%-- 因为这个id值已经封装到这个Book类中了，所以可以直接使用,因为你类中有这个id属性，new beanListhandler(Book.class) 会自动把同名属性赋值给同名变量          --%>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
<script>
    function fun1(id) {
        var aa = window.confirm('亲，确定要删除吗?')
        if (aa){
            document.location.href = "BookServlet?me=deleteById&id="+id
        }
    }
</script>