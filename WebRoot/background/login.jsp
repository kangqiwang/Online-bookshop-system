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
<title>��½����-�������������̨����ϵͳ</title>
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
						���������Ƽ��Ļ�ͼ���������ι�˾ [1024*768�ֱ��������Ч�����]
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
					
					<font color="blue"><b>�û���</b></font>	: <input name="name"/><br><br>
					<font color="blue"><b>����</b></font>	 ��<input type="password" name="pwd"/><br><br>
						<input type="submit" value="��½" /> <br><br>
					</div>
				</tr>
		</table>
		</form>
		<p align="center">
			
		</p>
	</body>
</html>
