<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="com.jzyqd.entity.CustomerInfo"%>
<%@page import="com.jzyqd.entity.CustomerDetailInfo"%>
<%@page import="com.jzyqd.servlet.gwc.IGwc"%>
<%@page import="java.util.Collection"%>
<%@page import="com.jzyqd.servlet.gwc.GwcItem"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XhTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="viewport" content="width=1024" />
<title>�ҵĹ����</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/orderInfo.css" />
<link rel="stylesheet" href="style/public.css" type="text/css" />

</head>
<body>
<form action="<%=request.getContextPath()%>/MakeOrderServlet">

<!-- top1 -->
<div class="top1">

	<div class="top1_1">
   	��ӭ��������������̳ǣ��û�����<input type="text" name="name" class="inputsty"> ���룺<input type="text" name="password" class="inputsty"> <a href="#">��������?</a> 
   	<input type="button" value="��¼" class="btn1">  <input type="button" value="ע��" class="btn1"> 
    </div>
	<div class="top1_2">
		<div class="top1_2_l">
            <ul class="yudingCon">
                <li>����:<input type="text" name="" class="kuang" />  </li>
            	<li>����:<input type="text" name="" class="kuang" />  </li>
            	<li class="ribtn"><input type="image" src="images/btn.gif" class="btn"/></li>
		</ul>
        </div>
		<div class="top1_2_r">
        	<ul class="other">
            	<li><a href="#"><img src="images/car.gif"><br />���ﳵ</a></li>
				<li><a href="#"><img src="images/car.gif"><br />������ѯ  </a></li>
				<li><a href="#"><img src="images/car.gif"><br />�ҵĿռ�</a></li>
				<li><a href="#"><img src="images/car.gif"><br />������� </a></li>
            </ul>
            <ul class="menu">
            	<li><a href="index.html">��ҳ</a></li>
                <li><a href="prolist.html">����</a></li>
                <li><a href="pro_show.html">��ѧ</a></li>
                <li><a href="#">������ϵ</a></li>
                <li><a href="#">�Ļ�</a></li>
                <li><a href="#">��Ӫ</a></li>
            </ul>
        </div>
	</div>
</div>
<div class="content">
    	  <div class="title2"></div>
        <!-- ����� -->
		<dl id="myCartTitle">
        	<dt>ȷ�϶�����Ϣ</dt>
        	<dd><a href="#">�����ջ���ַ</a></dd> 
		 </dl>
			<div class="clear"><img src="#" width="1" height="1"></div>
			<%
			CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
			CustomerDetailInfo customerDetailInfo = (CustomerDetailInfo)session.getAttribute("customerDetailInfo");
			%>
		 <div class="address"><!--�ջ��˵�ַ��ʼ--> 
				<div id=part_consignee>
				<div class=o_write>
				<h1>�ջ�����Ϣ&nbsp;
                  <span style="DISPLAY: none"><a style="COLOR: #ff6600" onclick=addNewAddress(this); href="javascript:void(0)">[����һ���µ�ַ]</a></span> 
                </h1>
				<div class=middle>
				<div id=addressListPanel></div>
				<div id=consignee_addr>
				<TABLE border=0 cellSpacing=0 width="100%">
				  <TBODY>
				  <TR>
					<TD vAlign=center width=85 align=right><FONT color=red>*</FONT>�ջ���������</TD>
					<TD vAlign=center align=left>
					<INPUT value="<%=customerInfo.getCustName() %>"
					name="customerName" class=txt maxLength=20 type=text>&nbsp; </TD>
			     </TR>
				 
				  <TR>
					<TD vAlign=center align=right><FONT color=red>*</FONT>�ء���ַ��</TD>
					<TD vAlign=center align=left><SPAN 
					  id=consigneeShow_addressName></SPAN>
					  <INPUT value="<%=customerDetailInfo.getAddress() %>"
					  style="WIDTh: 327px; MARGIN-LEFT: 2px" id=consignee_address class=txt 
					  name="address" maxLength=50 type=text>&nbsp; </TD></TR>
				  <TR>
					<TD vAlign=center align=right><FONT color=red>*</FONT>�ֻ����룺</TD>
					<TD vAlign=center align=left>
					<INPUT value="<%=customerDetailInfo.getTel() %>"
					  id=consignee_message class=txt name="tel"> &nbsp<FONT 
					  color=#000000>���ڽ��շ���֪ͨ���ż��ͻ�ǰȷ��</FONT> </TD>
				 </TR>
				 <TR>
					<TD vAlign=center align=right>��ע��</TD>
					<TD vAlign=center align=left>
					<INPUT value="" name="context"
					  id=consignee_message class=txt name="tel"> </TD>
				 </TR>
				  <TR>
					<TD vAlign=center align=right>�����ʼ���</TD>
					<TD vAlign=center align=left>
					<INPUT value="<%=customerInfo.getEmail() %>"
					  id=consignee_email class=txt type=text> &nbsp;<FONT 
					  color=#000000>�������ն��������ʼ�����������ʱ�˽ⶩ��״̬</FONT> </TD>
				  </TR>
				  </TBODY></TABLE></div></div>
				</div></div><!--�ջ��˵�ַ����--> 
				<!--֧����ʽ�����ͷ�ʽ��ʼ-->
			<div id=part_payTypeAndShipType>
			<div class=o_show>
			<h1>֧�������ͷ�ʽ&nbsp;<A id=linkPayTypeShipType 
			onclick=showForm_payTypeAndShipType(this); href="javascript:void(0)" 
			clstag="checkout|keycount|jiesuan|linkpayshiptype">[�޸�]</A></h1>
			<div id=updateInfo_payType></div>
			<div class=middle>
			<TABLE style="WIDTh: 100%">
			  <TBODY>
			  <TR>
				<TD style="TEXT-ALIGN: right; WIDTh: 80px">֧����ʽ��</TD>
				<TD>����֧��</TD></TR>
			  <TR>
				<TD style="TEXT-ALIGN: right">���ͷ�ʽ��</TD>
				<TD>�������</TD></TR>
			  <TR>
				<TD style="TEXT-ALIGN: right">�ˡ����ѣ�</TD>
				<TD>0.00Ԫ<SPAN style="COLOR: red">(���˷�)</SPAN></TD></TR>
			  <TR style="DISPLAY: none">
				<TD style="TEXT-ALIGN: right">�ͻ����ڣ�</TD>
				<TD style="COLOR: red">{CodTime}</TD></TR>
			  <TR style="DISPLAY: none">
				<TD style="TEXT-ALIGN: right">����ʱ�䣺</TD>
				<TD style="COLOR: red">{PickTime}</TD></TR></TBODY></TABLE></div>
			<div class=footsty></div></div></div><!--֧����ʽ�����ͷ�ʽ����-->
			<!--��Ʊ��Ϣ��ʼ-->
<div id=part_invoice>
<div class=o_show>
<h1>��Ʊ��Ϣ&nbsp;<A onclick=showForm_invoice(this) href="javascript:void(0)" 
clstag="checkout|keycount|jiesuan|xiugaifapiao">[�޸�]</A></h1>
<div class=middle>
<TABLE style="WIDTh: 100%; DISPLAY: none">
  <TBODY>
  <TR>
    <TD 
  style="TEXT-ALIGN: left; PADDING-LEFT: 22px">��ȡ���ͣ�&nbsp;Ĭ�Ͽ�ȡ</TD></TR></TBODY></TABLE>
<TABLE style="WIDTh: 100%">
  <TBODY>
  <TR>
    <TD style="TEXT-ALIGN: right; WIDTh: 82px">��Ʊ���ͣ�</TD>
    <TD>��ͨ��Ʊ</TD></TR>
  <TR>
    <TD style="TEXT-ALIGN: right">��Ʊ̧ͷ��</TD>
    <TD>���� </TD></TR>
  <TR>
    <TD style="TEXT-ALIGN: right">��Ʊ���ݣ�</TD>
    <TD>
      <div><SPAN style="DISPLAY: none">��ͼ����Ʒ��</SPAN><SPAN>��ϸ</SPAN></div>
      <div><SPAN style="DISPLAY: none">ͼ����Ʒ��</SPAN><SPAN 
      style="DISPLAY: none">������Ʊ</SPAN></div></TD></TR></TBODY></TABLE>
<TABLE style="WIDTh: 100%; DISPLAY: none">
  <TBODY>
  <TR>
    <TD 
style="TEXT-ALIGN: left; PADDING-LEFT: 22px">������Ʊ</TD></TR></TBODY></TABLE></div>
<div class=footsty></div></div></div><!--��Ʊ��Ϣ����--><!--Cart��Ϣ��ʼ-->
<div id=part_cart></div><!--Cart��Ϣ��ʼ--><!--�л��ȷ���ʼ-->
<div 
style="PADDING-BOTTOM: 8px; PADDING-LEFT: 30px; PADDING-RIGhT: 0px; COLOR: red; PADDING-TOP: 8px" 
id=part_FirstInstockShip><INPUT id=chk_FirstInstockShip 
onclick=SetTag_FirstInstockShip() type=checkbox>&nbsp;<LABEL 
for=chk_FirstInstockShip>�ȷ��л���Ʒ���������������Ʒȱ�������������л���Ʒ��</LABEL> </div><!--�л��ȷ�����-->
					 
		 
		 </div>
		 
    
	   
	    <dl id="myCartTitle">
        	<dt>ȷ����ѡ����Ʒ</dt>
        	<dd>��</dd>        
	    </dl>
		<div class="clear"><img src="#" width="1" height="1"></div>
		<div id="myCartTable">
		<table width="100%" border="0" cellspacing="" cellpadding="5">
		  <tr>
			<th>��Ʒ����</th>
			<th>���ۣ�Ԫ��</th>
			<th>����</th>
			<th>�Ż�</th>
			<th>С�ƣ�Ԫ��</th>
			<th>���ͻ���</th>
			<th>����</th>
		  </tr>
		   <%
		  	IGwc gwc = (IGwc)session.getAttribute("gwc");
		  	Collection<GwcItem> gwcItems = gwc.getAllItems();
		  	for(GwcItem item : gwcItems) { %>
		  	 <!-- gwcItem begin -->
		  <tr>
			<td align="left" width="400"><div class="shpic">
				<img src="<%=request.getContextPath()%>/background/imgsx/<%=item.getSmallImg()%>" /></div>
				<span class="shname">
				<a href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=item.getBookId()%>"><%=item.getBookName() %></a>
					<br />
		    	</span>
		    </td>
			<td align="center" width="100">
				�� �� ��<%=item.getHyprice() %>
				<span class="fccc"><del> <br />
				�г��ۣ�<%=item.getPrice() %> 
				</del></span>
			</td>
			<td align="center" width="70">
				<a title="��-" style="cursor:pointer" class="btn_minus_s"
				onclick="updateNum(<%=item.getBookId()%>, <%=item.getNum()-1%>)">-</a>  
				<input name="text"  class="text_num" value="<%=item.getNum() %>" size="2" maxlength="2" 
				onchange="updateNum(<%=item.getBookId()%>, this.value)"/>
				<a title="��-" style="cursor:pointer" class="btn_minus_s"
				onclick="updateNum(<%=item.getBookId()%>, <%=item.getNum()+1%>)">+</a>
			<td align="center" width="50"><%=(item.getPrice() - item.getHyprice()) * item.getNum() %></td>
			<td align="center" width="60"><%=item.getHyprice() * item.getNum() %></td>
			<td align="center" width="100">
				<span class="cols col-7">
				
					<a href="AddScjServlet?id=gg" style="cursor:pointer">�����ղ�</a> |	

				 <a href="<%=request.getContextPath()%>/DeleteGwcItemServlet?id=<%=item.getBookId() %>" style="cursor:pointer"
				  onclick="return confirm('��ȷ��Ҫɾ��[<%=item.getBookName()%>]��?');">ɾ��</a></span>
				 </td>
		  </tr>
		 <!-- gwcItem end --> 
		  		
		  <%	
		    }
		  %>
		 
		  
		  
		  <tr><td colspan="7" align="right" class="zongj">
		  	�ܼۣ�<%=gwc.getOldPrices()%>Ԫ -
                         �Żݣ�<%=gwc.getYhPrices() %>Ԫ
            = ��Ʒ�ܼ�(�����˷�)��<span class="fred"><%=gwc.getHyPrices() %>Ԫ</span>  ��ã�0 ���ֵ�</td>
		  </tr>
		  
		  <tr><td colspan="7">
		    <div class="left">
		       <a class="btn_clear_cart" href="<%=request.getContextPath()%>/InitIndexServlet"><img src="images/jxgw.png"></a>
               <a class="btn_clear_cart" onclick="return confirm('��ȷ��Ҫ��չ��ﳵ��?');" href="<%=request.getContextPath()%>/ClearGwcItemServlet"><img src="images/qkgw.png"></a>
            </div>
					 <div class="right" >
						<input type="image" src="images/tjdd.png">
					</div>
         </td></tr>
		</table>
		</div>
		
		
		  	
</div>
	<!-- footer -->
<div class="footer">
	<ul class="lbox">
    	<li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>
    <ul class="lbox">
    	<li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>
   	<ul class="lbox">
    	<li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>
   	<ul class="lbox nolbox">
    	<li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">�����ļ���״̬</a></li>
        <li><a href="#">��Ա�ȼ��ۿ�</a></li>
        <li><a href="#">���ֽ����ƻ�</a></li>
        <li><a href="#">�˿ͱض�</a></li>
        <li><a href="#">��Ʒ�˻���֤</a></li>
    </ul>




</div>
<div class="footer1">
	<img src="images/footer1img.jpg" />
	<img src="images/footer2img.jpg" /> 
	<img src="images/footer3img.jpg" />
	<img src="images/footer4img.jpg" />
  	<img src="images/footer5img.jpg" />
	<img src="images/footer6img.jpg" />           
</div>
<!-- footer2 -->
<div class="footer2">
��Ȩ���У�www.xubangyiliao.com<br />
�绰:029-62966051 87811277 ���棺029-62966051 ��ICP��1109231��
</div>
</form>
</body>
</html>

