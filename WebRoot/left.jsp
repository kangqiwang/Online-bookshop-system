<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="com.jzyqd.entity.BookInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.jzyqd.entity.BookDiscuss"%>
<%@page import="java.util.Map"%>
<%@page import="com.jzyqd.entity.BookType"%>
<%@page import="java.util.Set"%>

<%
            Map<BookType, List<BookType>> bookTypes = 
            		(Map<BookType, List<BookType>>)request.getAttribute("bookTypes");
	        	Set<BookType>  fqs = bookTypes.keySet();
	    		for (BookType fq : fqs) {%>
	    		<div class="l2">
                    <img src="images/icon.jpg" />
                    <a href="<%=request.getContextPath()%>/ShowBookListByTypeId?typeId=<%=fq.getBookTypeId()%>"><%=fq.getBookTypeName()%></a>£º
                    
                </div>
	    	<%		List<BookType> sons = bookTypes.get(fq);
	    			for (BookType son : sons) {%>
	    		<div class="l3">
                    &nbsp;&nbsp;&nbsp;<a href="<%=request.getContextPath()%>/ShowBookListByTypeId?typeId=<%=son.getBookTypeId()%>"><%=son.getBookTypeName() %></a><br />
                    
                </div>			
	    		<% }
	    		}
            %>
            