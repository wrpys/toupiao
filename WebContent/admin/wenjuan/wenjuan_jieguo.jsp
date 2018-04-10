<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/jquery-ui.css" />
    <script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="<%=path %>/js/jquery-ui.js"></script>
	
	<script type="text/javascript">
		var strUrl = null;
	    function toupiao_zhutu(toupiao_id)
	    {
	        strUrl = "<%=path %>/toupiao_zhutu.action?toupiao_id="+toupiao_id;
	        window.location.href=strUrl;
	        //$("#dialog").dialog("open");
	    }
	    $(function(){
    		$("#dialog").dialog({
    		      autoOpen: false,
    		      modal: true,
    		      width: 900,
    		      height: 600,
    		      open: function(ev, ui){
       	             $('#chartCount').attr('src',strUrl);  
    	          }
    		});
    	})
	</script>
  </head>
  
  <body>
        <table cellspacing="2" cellpadding="2" align="center">
		   <tr align="left"><td align="center" style="font-size: 22px;">${requestScope.wenjuan.mingcheng}</td></tr>
		</table>
		
		<c:forEach items="${requestScope.wenjuan.toupiaoList}"  varStatus="sta" var="toupiao">
		<table cellspacing="2" cellpadding="2">
			<tr>
				<td colspan="2">
					${sta.index+1 }：${toupiao.title }
					<a href="#" onclick="toupiao_zhutu(${toupiao.id })" style="color: red">柱状图</a>
				</td>
			</tr>
			<c:forEach items="${toupiao.xuanxiangList}" var="xuanxiang" varStatus="ss">
			<tr>
				<td>
				    <input type="radio" name="111" style="border: 0px;"/> 
				    ${xuanxiang.xuanxiangneirong}
				    (<font style="color: red">${xuanxiang.piaoshu}</font>)
				</td>
			</tr>
			</c:forEach>
		</table>
		<br/>
		</c:forEach>
		<div id="dialog" title="图形统计">
		  <iframe noresize="" id="chartCount" name="chartCount" 
		  scrolling="yes" style="width: 100%;height: 95%;border: 0;"></iframe>
		</div>
  </body>
</html>
