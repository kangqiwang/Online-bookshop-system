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
<title>�����</title>
<meta name="keywords" content="�ؼ���" />
<meta name="description" content="ҳ������" />
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
<!-- middle -->
<div class="middle">
	<div class="middle_left">
  		<div class="middle_left1">
        	<div class="middle_left1title">
            	������Ʒ����
            </div>
            <div class="middle_left1con">
            
            <%@include file="left.jsp" %>
            
            
               
               
            </div>
            <div class="zzzz">
            
            </div>
        </div>
        <div class="middle_left3">
        	<h3 class="paihtit">��������</h3>
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
        	����ǰ��λ�ã���վ��ҳ > ��Ʒ��� > 
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
            <td>�г��ۣ�<%=bookInfo.getPrice() %>Ԫ</td>
            <td>��Ʒ��:<%=bookInfo.getBookName() %></td>
          </tr>
          <tr>
            <td>��Ա�ۣ�379Ԫ</td>
            <td>��������355��</td>
          </tr>
          <tr>
            <td>����Ʒ�ƣ�������</td>
            <td>���������123456</td>
          </tr>
          <tr>
            <td>�г��ۣ�379Ԫ</td>
            <td>��Ʒ��:om1234567</td>
          </tr>
          <tr>
            <td>��Ա�ۣ�379Ԫ</td>
            <td>��������355��</td>
          </tr>
          <tr>
            <td>����Ʒ�ƣ�������</td>
            <td>���������123456</td>
          </tr>
          <tr>
            <td>�г��ۣ�379Ԫ</td>
            <td>��Ʒ��:om1234567</td>
          </tr>
          
          <tr>
            <td colspan="2">��Ʒ���ۣ� <img src="images/icon3.jpg" /> (����0������)</td>
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
            	<a href="#"><span>��Ʒ��Ϣ</span></a>
            </div>
            <div class="middle8con" >             
����������α�(����)(Сѧ����ѧ����)ͼ�Ĳ�ï�������Ͽڵİ����Ͽα��������������ǵ�ǰ���������Ϲ����ǵ��ǻۡ��������ǽ��˷������������Ϊ��Щ�Ͽα���������һ���Ĳο��ͽ���ļ�ֵ�����ǵ�����ѧ�����Ķ�ϰ�ߣ������ڱ���ԭ���ò�ķ�ͬʱ��ͬɾȥ��һЩ����ʱ�˵����ݡ�ԭ�����¸��м�����˵��������������α�����Ҷʥ�����Ա�д��ȫ���Ǵ������ٴ�������ȷ�ܷ�չ��ͯ���Ķ������ͱ������ΪĿ�꣬���ݽ�ϵ��ͯ����Ӷ�ͯ����Χ���ߣ�����չ����ᡣ���ϻ�����Ȥ��������ݲ�ȡ��������ѡ�����ģʽ���ʡ��䡢����н���ͯ���ǣ�����Ӧ��ͯѧϰ�������꼶�α�����������д�壬�ɷ�����д�����ͼ���ص���ͼ���������л���ϣ����ڵ�ʱͬ��̿������Ǻ���ӱ���������α���1932������ӡ��40���Ρ�����Ϊ��������α��ϲᡣ 

<p>��Ʒ��ţ� 35</p> 
<p>ISBN�� 9787543924857 </p> 
<p>ASIN�� B00116U33Q</p> 
<p>   
���ߣ� Ҷʥ��  </p>
<p>�����磺 �Ϻ���ѧ�������׳��� </p>
<p>�������ڣ� 2005-01-01</p> 
<p>��Σ� ��1�� </p>
<p>ҳ���� 196 </p>
<p>��װ�� ƽװ </p>
<p>����鼮�� ���а汾  ������� </p>

        </div>
        <div class="middle9">
        	<div class="middle9tit">����:</div>
        		<ul>
        			<%
        			for(BookDiscuss bookDiscuss: bookDiscusses) {%>
        				&nbsp;&nbsp;&nbsp;&nbsp;<%=bookDiscuss.getCustId()%>˵<%=bookDiscuss.getContext() %><br><br>
        			<%}
        			%>
        		
        		</ul>
        	</div>
        </div>
        <div class="middle9">
        	<div class="middle9tit">�û�����</div>
            <div class="middle_right9con">
            	<div>�û����������û�</div>
                <div>E-mail:<input type="text" name="text" size="25" ></div>
            	<div>���۵ȼ���<input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"> <input name="" type="radio" value="" /><img src="images/pl1.gif"></div>
            	<div>�������ݣ�<textarea name="" cols="" rows=""></textarea></div>
                <div>��֤�룺<input type="text"  size="15"><img src="images/yz.gif"></div>
                <div><input type="button"  class="btn4" value=" " ></div>
            </div>
            </div>        
        </div> 		   
        	   
	</div>

</div>
<!-- footer2 -->
<div class="footer3">
	<div class="footer3_in">
	<a href="#">��˾���</a><span>|</span><a href="#">��������</a><span>|</span><a href="#">��˽����</a><span>|</span><a href="#">��ѯ�ȵ�</a><span>|</span><a href="#">������ļ</a><span>|</span><a href="#">���ͷ�ʽ</a><span>|</span><a href="#">��ϵ����</a>
    </div>
    <div class="footer2">
    @ 2011-2012 ���ҽ���̳� ��Ȩ���У�����������Ȩ����<br />
    �绰:029-62966051 87811277 ���棺029-62966051 ��ICP��1109231�� ����֧�֣�<a href="#">��������</a>

    </div>
</div>
</body>
</html>

