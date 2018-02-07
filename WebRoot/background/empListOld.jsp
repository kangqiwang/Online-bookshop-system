<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="com.jzyqd.entity.Employee"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>员工信息列表</title>
    <style type="text/css">
    	@import '<%=request.getContextPath()%>/background/css/body.css'
    </style>
    <%
				List<Employee> emps = (List<Employee>)request.getAttribute("emps");
    			int nowPage = Integer.parseInt(request.getAttribute("nowPage").toString());
    			int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
    		%>
    <script type="text/javascript">
    	function haha() {
    		var result = confirm("你要怎么样吗?");
    		return result;  
    	}
    	function isDelete(empName) {
    		return confirm("您要删除[" + empName + "]吗?");
    	}
    	function gotoNowPage(nowPage) {
    		if(isNaN(nowPage)) {
    			alert("输入的页码必须是数字!!");
    			return;
    		}
    		if(nowPage <= 0 || nowPage > <%=pageCount%>) {
    			alert("您输入的页码超出范围!!");
    			return;
    		}
    		location = "<%=request.getContextPath()%>/FindAllEmployeeServlet?nowPage=" + nowPage;
    	}
    </script>
  </head>
  
  <body>
    	<table border="1">
    		<caption>员工信息列表</caption>
    		<tr>
    			<th>员工编号</th>
    			<th>员工姓名</th>
    			<th>员工生日</th>
    			<th>员工性别</th>
    			<th>员工年龄</th>
    			<th>修改</th>
    			<th>删除</th>
    		</tr>
    		<%for(Employee emp : emps) {%>
    			<tr onmouseover="this.bgColor='red'"
    				onmouseout="this.bgColor='white'">
    				<td><%=emp.getEmpId()%></td>
    				<td><%=emp.getEmpName()%></td>
    				<td><%=emp.getEmpBtd()%></td>
    				<td><%=emp.getEmpSex()%></td>
    				<td><%=emp.getEmpAge()%></td>
    				<td><a href="<%=request.getContextPath()%>/FindByEmployeeIdServlet?id=<%=emp.getEmpId() %>">update</a></td>
    				<td><a href="<%=request.getContextPath()%>/DeleteEmployeeServlet?id=<%=emp.getEmpId() %>"
    				onclick="return isDelete('<%=emp.getEmpName() %>');">delete</a></td>    			
    			</tr>
    		<%
    			}
    		%>
    		<tr>
    			<td colspan="7">
    				<a href="<%=request.getContextPath()%>/background/saveEmp.jsp">新增</a>
    				
    				共<%=pageCount%>页
    				第<%=nowPage %>页
    				<%if(nowPage == 1) {%>
    					第一页 上一页	
    				<%} else {%>
    					<a href="<%=request.getContextPath()%>/FindAllEmployeeServlet?nowPage=1">第一页</a>
    					<a href="<%=request.getContextPath()%>/FindAllEmployeeServlet?nowPage=<%=nowPage - 1%>">上一页</a>	
    				<%}
    				%>
    				<%if(nowPage == pageCount) {%>
    					下一页 最后页	
    				<%} else {%>
    					<a href="<%=request.getContextPath()%>/FindAllEmployeeServlet?nowPage=<%=nowPage + 1%>">下一页</a>
    					<a href="<%=request.getContextPath()%>/FindAllEmployeeServlet?nowPage=<%=pageCount%>">最后页</a>	
    				<%}
    				%>
    				<select onchange="gotoNowPage(this.value)">
						<%for(int i = 1; i <= pageCount; i++) {%>
							<option value="<%=i%>"
								<%if(nowPage == i){out.print("selected");} %>
							>第<%=i%>页</option>
						<%}
						%>    					
    				</select> 
					第
					<input size="2" value="<%=nowPage%>" onchange="gotoNowPage(this.value)">
					页	 
    			</td>
    		</tr>
    	</table>
  </body>
</html>








