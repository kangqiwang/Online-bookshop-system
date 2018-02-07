<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@page import="com.jzyqd.entity.BookInfo"%>
<%@page import="java.util.List"%>
<%@page import="com.jzyqd.entity.BookDiscuss"%>
<%@page import="java.util.Map"%>
<%@page import="com.jzyqd.entity.BookType"%>
<%@page import="java.util.Set"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>云起点</title>
<meta name="keywords" content="关键字" />
<meta name="description" content="页面描述" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<link rel="stylesheet" href="style/index.css" type="text/css" />
<script src="js/banner.js" type="text/javascript"></script>
<SCRIPT src="js/jquery-1.2.6.pack.js" type=text/javascript></SCRIPT>
<SCRIPT src="js/base.js" type=text/javascript></SCRIPT>

</head>
<body>
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
<!-- middle -->
<div class="middle">
	<div class="middle_left">
  		<div class="middle_left1">
        	<div class="middle_left1title">
            	所有商品分类
            </div>
            <div class="middle_left1con">
            
            <%@include file="left.jsp" %>
            
            
               
               
            </div>
            <div class="zzzz">
            
            </div>
        </div>
        <div class="middle_left3">
        	<h3 class="paihtit">最新排行</h3>
        	<%
        	List<BookInfo> rxBooks = (List<BookInfo>)request.getAttribute("rxBooks");
        	for(int i = 0; i < 10; i++) {
        		BookInfo zxphBook = rxBooks.get(i);
        	%>
        	<a href="<%=request.getContextPath()%>/ShowBookInfoServlet?id=<%=zxphBook.getBookId()%>"><%=zxphBook.getBookName()%></a>	
        	<%}%>

        </div> 
        <div class="middle_left2">
        	<img src="images/1.jpg">
        </div>
        <div class="middle_left2">
            <img src="images/2.jpg">
        </div>
         <div class="middle_left2">
            <img src="images/3.jpg">
         </div>
        
        
              
    </div>
    <div class="middle_right">
    	<div class="middle_right6tit">
        	您当前的位置：网站首页 > 产品类别 > 
        </div>
        <div class="middle_right6con">
        <%
    	BookInfo bookInfo = (BookInfo)request.getAttribute("bookInfo");
		List<BookDiscuss> bookDiscusses = (List<BookDiscuss>)request.getAttribute("bookDiscusses");
        %>
    <div id=preview>
            <div class=jqzoom id=spec-n1 onClick="window.open('http://www.lanrentuku.com/')"><IMG height=350
            src="<%=request.getContextPath()%>/background/imgsd/<%=bookInfo.getBigImg()%>" jqimg="<%=request.getContextPath()%>/background/imgsd/<%=bookInfo.getBigImg()%>" width=350>
            </div>
            <div id=spec-n5>
                <div class=control id=spec-left>
                    <img src="images/left.gif" />
                </div>
                <div id=spec-list>
                    <ul class=list-h>
                        <li><img src="<%=request.getContextPath()%>/imgsd/<%=bookInfo.getBigImg()%>"> </li>
                  
                    </ul>
                </div>
                <div class=control id=spec-right>
                    <img src="images/right.gif" />
                </div>
                
            </div>
        </div>
        <SCRIPT type=text/javascript>
            $(function(){			
               $(".jqzoom").jqueryzoom({
                    xzoom:400,
                    yzoom:400,
                    offset:10,
                    position:"right",
                    preload:1,
                    lens:1
                });
                $("#spec-list").jdMarquee({
                    deriction:"left",
                    width:350,
                    height:56,
                    step:2,
                    speed:4,
                    delay:10,
                    control:true,
                    _front:"#spec-right",
                    _back:"#spec-left"
                });
                $("#spec-list img").bind("mouseover",function(){
                    var src=$(this).attr("src");
                    $("#spec-n1 img").eq(0).attr({
                        src:src.replace("\/n5\/","\/n1\/"),
                        jqimg:src.replace("\/n5\/","\/n0\/")
                    });
                    $(this).css({
                        "border":"2px solid #ff6600",
                        "padding":"1px"
                    });
                }).bind("mouseout",function(){
                    $(this).css({
                        "border":"1px solid #ccc",
                        "padding":"2px"
                    });
                });				
            })
            </SCRIPT>
        
        <SCRIPT src="js/lib.js" type=text/javascript></SCRIPT>
        <SCRIPT src="js/163css.js" type=text/javascript></SCRIPT>

         <div class="middle_rightR">
        <table width="100%" border="0">
          <tr>
            <td>市场价：<%=bookInfo.getPrice() %>元</td>
            <td>商品货:<%=bookInfo.getBookName() %></td>
          </tr>
          <tr>
            <td>会员价：379元</td>
            <td>库存情况：355件</td>
          </tr>
          <tr>
            <td>所属品牌：阿依莲</td>
            <td>点击次数：123456</td>
          </tr>
          <tr>
            <td>市场价：379元</td>
            <td>商品货:om1234567</td>
          </tr>
          <tr>
            <td>会员价：379元</td>
            <td>库存情况：355件</td>
          </tr>
          <tr>
            <td>所属品牌：阿依莲</td>
            <td>点击次数：123456</td>
          </tr>
          <tr>
            <td>市场价：379元</td>
            <td>商品货:om1234567</td>
          </tr>
          
          <tr>
            <td colspan="2">商品评论： <img src="images/icon3.jpg" /> (已有0人评论)</td>
          </tr>
        </table>
        <div class="middle_rightRC"> 
 	 	<a href="<%=request.getContextPath()%>/AddGwcItemServlet?id=<%=bookInfo.getBookId()%>">
 	 		<img src="images/jr.jpg"/>
 	 	</a>
         </div>
      </div>
        
        
        
        </div> 	
        <div class="middle8">
        	<div class="middle8tit">
            	<a href="#"><span>产品信息</span></a>
            </div>
            <div class="middle8con" >             
《开明国语课本(上下)(小学初级学生用)图文并茂、琅琅上口的百年老课本曾经滋养了我们的前辈，并启迪过他们的智慧。今天我们将此发掘出来，是因为这些老课本或许还具有一定的参考和借鉴的价值。考虑到今天学生的阅读习惯，作者在保留原书风貌的风同时，同删去了一些不合时宜的内容。原课文下附有简体字说明。《开明国语课本》由叶圣陶亲自编写，全部是创作或再创作。以确能发展儿童的阅读能力和表达能力为目标，内容紧系儿童生活，从儿童儿周围开邕，逐渐拓展到社会。材料活泼隽趣，文体兼容博取，文章力选各体的模式，词、句、语调切近儿童口吻，以适应儿童学习心理。初年级课本的文字用手写体，由丰子恺写并绘插图。特点是图画与文字有机配合，这在当时同类教科书中是很新颖的作法。课本于1932年初版后印行40余版次。此书为开明国语课本上册。 

<p>商品编号： 35</p> 
<p>ISBN： 9787543924857 </p> 
<p>ASIN： B00116U33Q</p> 
<p>   
作者： 叶圣陶  </p>
<p>出版社： 上海科学技术文献出版 </p>
<p>出版日期： 2005-01-01</p> 
<p>版次： 第1版 </p>
<p>页数： 196 </p>
<p>包装： 平装 </p>
<p>相关书籍： 所有版本  相近的书 </p>

        </div>
        <div class="middle9">
        	<div class="middle9tit">书评:</div>
        		<ul>
        			<%
        			for(BookDiscuss bookDiscuss: bookDiscusses) {%>
        				&nbsp;&nbsp;&nbsp;&nbsp;<%=bookDiscuss.getCustId()%>说<%=bookDiscuss.getContext() %><br><br>
        			<%}
        			%>
        		
        		</ul>
        	</div>
        </div>
        <div class="middle9">
        	<div class="middle9tit">用户评论</div>
            <div class="middle_right9con">
            	<div>用户名：匿名用户</div>
                <div>E-mail:<input type="text" name="text" size="25" ></div>
            	<div>评论等级：<input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"></div>
            	<div>评论内容：<textarea name="" cols="" rows=""></textarea></div>
                <div>验证码：<input type="text"  size="15"><img src="images/yz.gif"></div>
                <div><input type="button"  class="btn4" value=" " ></div>
            </div>
            </div>        
        </div> 		   
        	   
	</div>

</div>
<!-- footer2 -->
<div class="footer3">
	<div class="footer3_in">
	<a href="#">公司简介</a><span>|</span><a href="#">免责条款</a><span>|</span><a href="#">隐私保护</a><span>|</span><a href="#">咨询热点</a><span>|</span><a href="#">合作招募</a><span>|</span><a href="#">配送方式</a><span>|</span><a href="#">联系我们</a>
    </div>
    <div class="footer2">
    @ 2011-2012 旭邦医疗商城 版权所有，并保留所有权利。<br />
    电话:029-62966051 87811277 传真：029-62966051 陕ICP备1109231号 技术支持：<a href="#">徽韵网络</a>

    </div>
</div>
</body>
</html>

