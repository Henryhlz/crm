<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>分页</title>
</head>
<SCRIPT language=javascript>
    function toPage(num) {
        document.getElementById("pageNum").value = num;
        document.forms[0].submit();
    }
</SCRIPT>
<style type="text/css">
    td div {
        margin-top: 15px;
    }

    div a {
        border: 1px solid lightblue;
        padding: 3px 3px 3px 3px;
        border-radius: 20%;
    }

    a:active {
        border-top: 3px solid lightblue;
        border-left: 3px solid lightblue;
        border-right: 1px solid white;
        border-bottom: 1px solid white;
    }
</style>
<body>
<div>
    <input type="hidden" id="pageNum" name="pageNum" value=""/>
    <a href="javascript:toPage(1)">首页</a>
    <a href="javascript:toPage(${page.upPageNum})">上一页</a>
    <s:iterator begin="%{page.beginPageNum}" end="%{page.endPageNum}" var="snum">
        <a href="javascript:toPage(${snum})">${snum}</a>
    </s:iterator>
    <a href="javascript:toPage(${page.nextPageNum})">下一页</a>
    <a href="javascript:toPage(${page.totalPageNum})">末页</a>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    第${page.currentPageNum}页/共${page.totalPageNum}页
</div>
</body>
</html>
