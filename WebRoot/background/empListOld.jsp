<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="java.util.List"%>
<%@page import="com.jzyqd.entity.Employee"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Ա����Ϣ�б�</title>
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
    		var result = confirm("��Ҫ��ô����?");
    		return result;  
    	}
    	function isDelete(empName) {
    		return confirm("��Ҫɾ��[" + empName + "]��?");
    	}
    	function gotoNowPage(nowPage) {
    		if(isNaN(nowPage)) {
    			alert("�����ҳ�����������!!");
    			return;
    		}
    		if(nowPage <= 0 || nowPage > <%=pageCount%>) {
    			alert("�������ҳ�볬����Χ!!");
    			return;
    		}
    		location = "<%=request.getContextPath()%>/FindAllEmployeeServlet?nowPage=" + nowPage;
    	}
    </script>
  </head>
  
  <body>
    	<table border="1">
    		<caption>Ա����Ϣ�б�</caption>
    		<tr>
    			<th>Ա�����</th>
    			<th>Ա������</th>
    			<th>Ա������</th>
    			<th>Ա���Ա�</th>
    			<th>Ա������</th>
    			<th>�޸�</th>
    			<th>ɾ��</th>
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
    				<a href="<%=request.getContextPath()%>/background/saveEmp.jsp">����</a>
    				
    				��<%=pageCount%>ҳ
    				��<%=nowPage %>ҳ
    				<%if(nowPage == 1) {%>
    					��һҳ ��һҳ	
    				<%} else {%>
    					<a href="<%=request.getContextPath()%>/FindAllEmployeeServlet?nowPage=1">��һҳ</a>
    					<a href="<%=request.getContextPath()%>/FindAllEmployeeServlet?nowPage=<%=nowPage - 1%>">��һҳ</a>	
    				<%}
    				%>
    				<%if(nowPage == pageCount) {%>
    					��һҳ ���ҳ	
    				<%} else {%>
    					<a href="<%=request.getContextPath()%>/FindAllEmployeeServlet?nowPage=<%=nowPage + 1%>">��һҳ</a>
    					<a href="<%=request.getContextPath()%>/FindAllEmployeeServlet?nowPage=<%=pageCount%>">���ҳ</a>	
    				<%}
    				%>
    				<select onchange="gotoNowPage(this.value)">
						<%for(int i = 1; i <= pageCount; i++) {%>
							<option value="<%=i%>"
								<%if(nowPage == i){out.print("selected");} %>
							>��<%=i%>ҳ</option>
						<%}
						%>    					
    				</select> 
					��
					<input size="2" value="<%=nowPage%>" onchange="gotoNowPage(this.value)">
					ҳ	 
    			</td>
    		</tr>
    	</table>
  </body>
</html>








