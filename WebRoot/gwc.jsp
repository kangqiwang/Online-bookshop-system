<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
<meta name="viewport" content="width=1024" />
<title>�ҵĹ����</title>
<link rel="stylesheet" type="text/css" href="style/style.css" />
<link rel="stylesheet" href="style/public.css" type="text/css" />
<script type="text/javaScript">
	function isDelete(bookName) {
		return confirm("��ȷ��Ҫɾ����Ʒ[" + bookName + "]��?");
	}
	function updateGwcItemNum(bookId, num) {
		if(isNaN(num)) {
			alert("�����ͼ����������������!");
			return;
		}
		var a = parseInt(num);
		if(a <= 0) {
			alert("�����ͼ������������ڵ���1!");
			return;
		}
		var url = "${pageContext.request.contextPath}/UpdateGwcItemNumServlet?id=" + bookId + "&num=" + num;
		
		location = url; 
	}
</script>
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
<div class="content">
    	  <div class="title1"></div>
        <!-- ����� -->
        <dl id="myCartTitle">
        	<dt>����ѡ����Ʒ</dt>
        	<dd>���� <a href="#">��¼</a>����Ʒ�����ñ��浽���ҵĹ������</dd>        </dl>
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
	 <c:forEach var="item" items="${sessionScope.gwc.allItems}">
	
		  <tr>
			<td align="left" width="400">
				<div class="shpic"><img src="${pageContext.request.contextPath}/imgsx/${item.smallImg}" /></div>
				<span class="shname">
				<a href="${pageContext.request.contextPath}/ShowBookInfoServlet?id=${item.bookId}">${item.bookName}</a><br />
		   	<span class="fccc"> ��ɫ�������� ���룺170/</span>92A</span>
		   </td>
			<td align="center" width="100">�� �� ��${item.hyprice}<span class="fccc"><del> <br />
		    	�г��ۣ�${item.price}</del></span>
          	</td>
			<td align="center" width="70">
			<a title="��-" style="cursor:pointer" class="btn_minus_s"
			href="${pageContext.request.contextPath}/UpdateGwcItemNumServlet?id=${item.bookId}&num=${item.num - 1}">-</a>  
				<input type="text" class="text_num" value="${item.num}" size="2" maxlength="2" autocomplete="off" 
				onchange="updateGwcItemNum(${item.bookId},this.value)"/>
			<a title="��+" style="cursor:pointer" class="btn_plus_s"
			href="${pageContext.request.contextPath}/UpdateGwcItemNumServlet?id=${item.bookId}&num=${item.num + 1}">+</a>
			<td align="center" width="50">${item.num * (item.price - item.hyprice)}</td>
			<td align="center" width="60">${item.num * item.hyprice}</td>
			<td align="center" width="50"><span class="cols col-6"><span>0 </span></span></td>
			<td align="center" width="100">
				<span class="cols col-7">
				<c:if test="${!(empty sessionScope.customerInfo)}">
					<a style="cursor:pointer">�����ղ�</a> |
				</c:if>
				<a style="cursor:pointer" href="${pageContext.request.contextPath}/DeleteGwcItemServlet?id=${item.bookId}"
					onclick="return isDelete('${item.bookName}');">ɾ��</a>
				</span>
			</td>
		  </tr>	
	</c:forEach>

		  
		  <tr><td colspan="7" align="right" class="zongj">
		  �ܼۣ�${sessionScope.gwc.oldPrices}Ԫ -
                        �Żݣ�${sessionScope.gwc.yhPrices}Ԫ
              = ��Ʒ�ܼ�(�����˷�)��<span class="fred">
              ${sessionScope.gwc.hyPrices}Ԫ</span>  ��ã�0 ���ֵ�</td>
		  </tr>
		  <tr><td colspan="7"><div class="left">
					 <a class="btn_clear_cart"
					 href="${pageContext.request.contextPath}/InitIndexServlet"><img src="images/jxgw.png"></a>
                    <a  class="btn_clear_cart"
                    href="${pageContext.request.contextPath}/ClearGwcItemServlet"
                    onclick="return confirm('��ȷ��Ҫ��չ��ﳵ��?');"><img src="images/qkgw.png"></a>
                    </div>
					 <div class="right" >
					<a href="${pageContext.request.contextPath}/InitOrderServlet" class="bg_cart btn_check_order" >
						<img src="images/jies.png">
					</a>
					</div>
         </td></tr>
		</table>
		</div>
		<div id="interested">
			<h3>�����ܸ���Ȥ�ı���&hellip;</h3>
				<a href="#" class="J_ClearBrowse clear" style="display: none;">���</a>
			<div class="con">
				<ul class="tabs" id="menu3">
					<li onmouseOver="settab(3,0)"  class="current "><a href="#"><span>����ղص�</span></a></li>
					<li onmouseOver="settab(3,1)"><a href="#"><span>����������</span></a></li>
					<li onmouseOver="settab(3,2)"><a href="#"><span>����ϲ����</span></a></li>
				</ul>
						<div id="main3">
							<ul class="pannel">
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα�����</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a></li>
							</ul>
						
						<ul class="pannel" style="display:none; ">
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα�����</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα�����������</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα��������� </span> <span  class="fred">��299</span></a></li></ul>
						<ul class="pannel"  style="display:none; ">
									<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα��������� </span> <span  class="fred">��299</span></a> </li>
								<li class="pic"><a href="#" class="list"><img src="images/pic3.jpg"><br /><span class="text">M�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a></li>
								<li class="pic"><a href="#" class="list"><img src="images/pic2.jpg"><br /><span class="text">�����Ͽڵİ����Ͽα���������</span> <span  class="fred">��299</span></a></li>
						</ul>         
			  </div></div>
		</div>
		
		<div class="clear"><img src="#" width="1" height="1"></div>  	
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

</body>
<script language="javascript"><!-- 
function settab(m,n){ 
var tli=document.getElementById("menu"+m).getElementsByTagName("li"); 
var mli=document.getElementById("main"+m).getElementsByTagName("ul"); 
for(i=0;i<tli.length;i++){ 
tli[i].className=i==n?"current":""; 
mli[i].style.display=i==n?"block":"none"; 
} 
} 
// --></script>

</html>

