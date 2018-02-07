<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
<!--
.wr{font-size: 12pt; line-height: 22px}
.wr1 {	FONT-SIZE: 12px; LINE-HEIGHT: 200%}
.wr2 {	FONT-SIZE: 14px; LINE-HEIGHT: 200%}
.wr3 {	FONT-SIZE: 12px}
.wr4 {	FONT-SIZE: 12px; LINE-HEIGHT: 150%}
// -->
</style>
<title>登陆界面-云起点网上书店后台管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
</head>

<body bgcolor="#BDE7FD" text="#000000" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<table width="500" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="50">
					&nbsp;
				</td>
				<td>
					<img src="${path}/background/images/ht01.jpg" width="65" height="65">
				</td>
				<td>
				</td>
			</tr>
		</table>
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			bgcolor="#BDE7FD">
			<tr>
				<td class="wr2">
					<div align="center">
						西安云起点科技文化图书有限责任公司 [1024*768分辨率下浏览效果最佳]
					</div>
				</td>
			</tr>
		</table>
		<form action="${pageContext.request.contextPath}/BackgroundLoginServlet" method="post">
		
		<table width="100%" border="0" cellspacing="0" cellpadding="0"
			bgcolor="#BDE7FD">
				
				<tr>
				<td class="wr2">
					<div align="center">
					
					<font color="blue"><b>用户名</b></font>	: <input name="name"/><br><br>
					<font color="blue"><b>密码</b></font>	 ：<input type="password" name="pwd"/><br><br>
						<input type="submit" value="登陆" /> <br><br>
					</div>
				</tr>
		</table>
		</form>
		<p align="center">
			
		</p>
	</body>
</html>
