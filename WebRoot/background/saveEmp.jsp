<%@ page language="java" contentType="text/html; charset=gbk"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>����Ա��</title>
    <style type="text/css">
    	@import '${pageContext.request.contextPath}/background/css/addUpdate.css'
    </style>
  </head>
  
  <body>
  <form action="${pageContext.request.contextPath}/SaveEmployeeServlet" method="post">
    	<table align="center">
    		<caption>����Ա����Ϣ</caption>
    		<tr>
    			<td>Ա������:</td>
    			<td><input type="text" name="empName"></td>
    		</tr>
    		<tr>
    			<td>Ա������:</td>
    			<td><input type="text" name="empBtd"></td>
    		</tr>
    		<tr>
    			<td>Ա���Ա�:</td>
    			<td>
    				<input type="radio" name="empSex" value="1" checked="checked">��
    				<input type="radio" name="empSex" value="0">Ů
    			</td>
    		</tr>
    		<tr>
    			<td>Ա������:</td>
    			<td><input type="text" name="empAge"></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="submit" /></td>
    			<td><input type="reset" value="reset" />
    			</td>
    		</tr>
    	</table>
</form>    	
  </body>
</html>
