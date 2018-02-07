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
<title>我的购物袋</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" type="text/css" href="style/orderInfo.css" />
<link rel="stylesheet" href="style/public.css" type="text/css" />

</head>
<body>
<form action="<%=request.getContextPath()%>/MakeOrderServlet">

<!-- top1 -->
<div class="top1">

	<div class="top1_1">
   	欢迎您登云起点网上商城！用户名：<input type="text" name="name" class="inputsty"> 密码：<input type="text" name="password" class="inputsty"> <a href="#">忘记密码?</a> 
   	<input type="button" value="登录" class="btn1">  <input type="button" value="注册" class="btn1"> 
    </div>
	<div class="top1_2">
		<div class="top1_2_l">
            <ul class="yudingCon">
                <li>书名:<input type="text" name="" class="kuang" />  </li>
            	<li>作者:<input type="text" name="" class="kuang" />  </li>
            	<li class="ribtn"><input type="image" src="images/btn.gif" class="btn"/></li>
		</ul>
        </div>
		<div class="top1_2_r">
        	<ul class="other">
            	<li><a href="#"><img src="images/car.gif"><br />购物车</a></li>
				<li><a href="#"><img src="images/car.gif"><br />订单查询  </a></li>
				<li><a href="#"><img src="images/car.gif"><br />我的空间</a></li>
				<li><a href="#"><img src="images/car.gif"><br />购书服务 </a></li>
            </ul>
            <ul class="menu">
            	<li><a href="index.html">首页</a></li>
                <li><a href="prolist.html">畅销</a></li>
                <li><a href="pro_show.html">文学</a></li>
                <li><a href="#">旺旺书系</a></li>
                <li><a href="#">文化</a></li>
                <li><a href="#">经营</a></li>
            </ul>
        </div>
	</div>
</div>
<div class="content">
    	  <div class="title2"></div>
        <!-- 购物袋 -->
		<dl id="myCartTitle">
        	<dt>确认订单信息</dt>
        	<dd><a href="#">管理收货地址</a></dd> 
		 </dl>
			<div class="clear"><img src="#" width="1" height="1"></div>
			<%
			CustomerInfo customerInfo = (CustomerInfo)session.getAttribute("customerInfo");
			CustomerDetailInfo customerDetailInfo = (CustomerDetailInfo)session.getAttribute("customerDetailInfo");
			%>
		 <div class="address"><!--收货人地址开始--> 
				<div id=part_consignee>
				<div class=o_write>
				<h1>收货人信息&nbsp;
                  <span style="DISPLAY: none"><a style="COLOR: #ff6600" onclick=addNewAddress(this); href="javascript:void(0)">[创建一个新地址]</a></span> 
                </h1>
				<div class=middle>
				<div id=addressListPanel></div>
				<div id=consignee_addr>
				<TABLE border=0 cellSpacing=0 width="100%">
				  <TBODY>
				  <TR>
					<TD vAlign=center width=85 align=right><FONT color=red>*</FONT>收货人姓名：</TD>
					<TD vAlign=center align=left>
					<INPUT value="<%=customerInfo.getCustName() %>"
					name="customerName" class=txt maxLength=20 type=text>&nbsp; </TD>
			     </TR>
				 
				  <TR>
					<TD vAlign=center align=right><FONT color=red>*</FONT>地　　址：</TD>
					<TD vAlign=center align=left><SPAN 
					  id=consigneeShow_addressName></SPAN>
					  <INPUT value="<%=customerDetailInfo.getAddress() %>"
					  style="WIDTh: 327px; MARGIN-LEFT: 2px" id=consignee_address class=txt 
					  name="address" maxLength=50 type=text>&nbsp; </TD></TR>
				  <TR>
					<TD vAlign=center align=right><FONT color=red>*</FONT>手机号码：</TD>
					<TD vAlign=center align=left>
					<INPUT value="<%=customerDetailInfo.getTel() %>"
					  id=consignee_message class=txt name="tel"> &nbsp<FONT 
					  color=#000000>用于接收发货通知短信及送货前确认</FONT> </TD>
				 </TR>
				 <TR>
					<TD vAlign=center align=right>备注：</TD>
					<TD vAlign=center align=left>
					<INPUT value="" name="context"
					  id=consignee_message class=txt name="tel"> </TD>
				 </TR>
				  <TR>
					<TD vAlign=center align=right>电子邮件：</TD>
					<TD vAlign=center align=left>
					<INPUT value="<%=customerInfo.getEmail() %>"
					  id=consignee_email class=txt type=text> &nbsp;<FONT 
					  color=#000000>用来接收订单提醒邮件，便于您及时了解订单状态</FONT> </TD>
				  </TR>
				  </TBODY></TABLE></div></div>
				</div></div><!--收货人地址结束--> 
				<!--支付方式及配送方式开始-->
			<div id=part_payTypeAndShipType>
			<div class=o_show>
			<h1>支付及配送方式&nbsp;<A id=linkPayTypeShipType 
			onclick=showForm_payTypeAndShipType(this); href="javascript:void(0)" 
			clstag="checkout|keycount|jiesuan|linkpayshiptype">[修改]</A></h1>
			<div id=updateInfo_payType></div>
			<div class=middle>
			<TABLE style="WIDTh: 100%">
			  <TBODY>
			  <TR>
				<TD style="TEXT-ALIGN: right; WIDTh: 80px">支付方式：</TD>
				<TD>在线支付</TD></TR>
			  <TR>
				<TD style="TEXT-ALIGN: right">配送方式：</TD>
				<TD>快递运输</TD></TR>
			  <TR>
				<TD style="TEXT-ALIGN: right">运　　费：</TD>
				<TD>0.00元<SPAN style="COLOR: red">(免运费)</SPAN></TD></TR>
			  <TR style="DISPLAY: none">
				<TD style="TEXT-ALIGN: right">送货日期：</TD>
				<TD style="COLOR: red">{CodTime}</TD></TR>
			  <TR style="DISPLAY: none">
				<TD style="TEXT-ALIGN: right">自提时间：</TD>
				<TD style="COLOR: red">{PickTime}</TD></TR></TBODY></TABLE></div>
			<div class=footsty></div></div></div><!--支付方式及配送方式结束-->
			<!--发票信息开始-->
<div id=part_invoice>
<div class=o_show>
<h1>发票信息&nbsp;<A onclick=showForm_invoice(this) href="javascript:void(0)" 
clstag="checkout|keycount|jiesuan|xiugaifapiao">[修改]</A></h1>
<div class=middle>
<TABLE style="WIDTh: 100%; DISPLAY: none">
  <TBODY>
  <TR>
    <TD 
  style="TEXT-ALIGN: left; PADDING-LEFT: 22px">开取类型：&nbsp;默认开取</TD></TR></TBODY></TABLE>
<TABLE style="WIDTh: 100%">
  <TBODY>
  <TR>
    <TD style="TEXT-ALIGN: right; WIDTh: 82px">发票类型：</TD>
    <TD>普通发票</TD></TR>
  <TR>
    <TD style="TEXT-ALIGN: right">发票抬头：</TD>
    <TD>个人 </TD></TR>
  <TR>
    <TD style="TEXT-ALIGN: right">发票内容：</TD>
    <TD>
      <div><SPAN style="DISPLAY: none">非图书商品：</SPAN><SPAN>明细</SPAN></div>
      <div><SPAN style="DISPLAY: none">图书商品：</SPAN><SPAN 
      style="DISPLAY: none">不开发票</SPAN></div></TD></TR></TBODY></TABLE>
<TABLE style="WIDTh: 100%; DISPLAY: none">
  <TBODY>
  <TR>
    <TD 
style="TEXT-ALIGN: left; PADDING-LEFT: 22px">不开发票</TD></TR></TBODY></TABLE></div>
<div class=footsty></div></div></div><!--发票信息结束--><!--Cart信息开始-->
<div id=part_cart></div><!--Cart信息开始--><!--有货先发开始-->
<div 
style="PADDING-BOTTOM: 8px; PADDING-LEFT: 30px; PADDING-RIGhT: 0px; COLOR: red; PADDING-TOP: 8px" 
id=part_FirstInstockShip><INPUT id=chk_FirstInstockShip 
onclick=SetTag_FirstInstockShip() type=checkbox>&nbsp;<LABEL 
for=chk_FirstInstockShip>先发有货商品（如果订单部分商品缺货，优先配送有货商品）</LABEL> </div><!--有货先发结束-->
					 
		 
		 </div>
		 
    
	   
	    <dl id="myCartTitle">
        	<dt>确认挑选的商品</dt>
        	<dd>”</dd>        
	    </dl>
		<div class="clear"><img src="#" width="1" height="1"></div>
		<div id="myCartTable">
		<table width="100%" border="0" cellspacing="" cellpadding="5">
		  <tr>
			<th>商品名称</th>
			<th>单价（元）</th>
			<th>数量</th>
			<th>优惠</th>
			<th>小计（元）</th>
			<th>赠送积分</th>
			<th>操作</th>
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
				售 价 ：<%=item.getHyprice() %>
				<span class="fccc"><del> <br />
				市场价：<%=item.getPrice() %> 
				</del></span>
			</td>
			<td align="center" width="70">
				<a title="减-" style="cursor:pointer" class="btn_minus_s"
				onclick="updateNum(<%=item.getBookId()%>, <%=item.getNum()-1%>)">-</a>  
				<input name="text"  class="text_num" value="<%=item.getNum() %>" size="2" maxlength="2" 
				onchange="updateNum(<%=item.getBookId()%>, this.value)"/>
				<a title="加-" style="cursor:pointer" class="btn_minus_s"
				onclick="updateNum(<%=item.getBookId()%>, <%=item.getNum()+1%>)">+</a>
			<td align="center" width="50"><%=(item.getPrice() - item.getHyprice()) * item.getNum() %></td>
			<td align="center" width="60"><%=item.getHyprice() * item.getNum() %></td>
			<td align="center" width="100">
				<span class="cols col-7">
				
					<a href="AddScjServlet?id=gg" style="cursor:pointer">加入收藏</a> |	

				 <a href="<%=request.getContextPath()%>/DeleteGwcItemServlet?id=<%=item.getBookId() %>" style="cursor:pointer"
				  onclick="return confirm('您确定要删除[<%=item.getBookName()%>]吗?');">删除</a></span>
				 </td>
		  </tr>
		 <!-- gwcItem end --> 
		  		
		  <%	
		    }
		  %>
		 
		  
		  
		  <tr><td colspan="7" align="right" class="zongj">
		  	总价：<%=gwc.getOldPrices()%>元 -
                         优惠：<%=gwc.getYhPrices() %>元
            = 商品总计(不含运费)：<span class="fred"><%=gwc.getHyPrices() %>元</span>  获得：0 积分点</td>
		  </tr>
		  
		  <tr><td colspan="7">
		    <div class="left">
		       <a class="btn_clear_cart" href="<%=request.getContextPath()%>/InitIndexServlet"><img src="images/jxgw.png"></a>
               <a class="btn_clear_cart" onclick="return confirm('您确定要清空购物车吗?');" href="<%=request.getContextPath()%>/ClearGwcItemServlet"><img src="images/qkgw.png"></a>
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
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>
    <ul class="lbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>
   	<ul class="lbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
    </ul>
   	<ul class="lbox nolbox">
    	<li><a href="#">顾客必读</a></li>
        <li><a href="#">订单的几种状态</a></li>
        <li><a href="#">会员等级折扣</a></li>
        <li><a href="#">积分奖励计划</a></li>
        <li><a href="#">顾客必读</a></li>
        <li><a href="#">商品退货保证</a></li>
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
版权所有：www.xubangyiliao.com<br />
电话:029-62966051 87811277 传真：029-62966051 陕ICP备1109231号
</div>
</form>
</body>
</html>

