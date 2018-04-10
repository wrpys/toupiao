<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		
		<link href="<%=path %>/css/layout.css" type="text/css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/jquery-ui.css" />
        <script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="<%=path %>/js/jquery-ui.js"></script>
		
	    <script type="text/javascript">
    	   var wenjuan_id = null;
    	   var mingchengType = null;
	       function wenjuanDetailQian(id, type)
           {
	    	   wenjuan_id = id;
	    	   mingchengType = type;
	    	   $("#dialog").dialog("open");
           } 
	       $(function(){
        		$("#dialog").dialog({
        		      autoOpen: false,
        		      modal: true,
        		      width: 700,
        		      height: 500,
        		      open: function(ev, ui){
        		    	 if(mingchengType == 2) {
	        	             $('#subjectRel').attr('src','<%=path%>/getTimuByWenjuanIdOne2.action?wenjuan_id=' + wenjuan_id + '&mingchengType=' + mingchengType);  
        		    		 
        		    	 } else {
	        	             $('#subjectRel').attr('src','<%=path%>/getTimuByWenjuanId1.action?wenjuan_id=' + wenjuan_id + '&mingchengType=' + mingchengType);  
        		    		 
        		    	 }
        	          }
        		});
        	})
	    </script>
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<div class="page_main_msg left">
			     <div class="left_row">
		              <div class="list pic_news">
				          <div class="list_bar">问卷信息列表</div>
				          <div class="list_content" style="height: 445px;">
                              <div class="c1-body">
                                  <s:iterator value="#request.wenjuanList" id="wenjuan">
                                  <div class="c1-bline" style="padding:7px 0px;">
                                       <div class="f-left">
                                            <img src="<%=path %>/img/head-mark4.gif" align="middle" class="img-vm" border="0"/> 
                                            <a href="#" onclick="wenjuanDetailQian(<s:property value="#wenjuan.id"/>,<s:property value="#wenjuan.mingchengType"/>)">
                                            <s:property value="#wenjuan.mingcheng"/></a>
                                       </div>
                                       <div class="f-right"><s:property value="#wenjuan.shijian"/></div>
                                       <div class="clear"></div>
                                  </div>
                                  </s:iterator>
								  <div class="pg-3">
									   <!--  分页-->
								  </div>		  
						      </div>
						  </div>
					  </div>	
				      <div style="clear:both;"></div>
			     </div>
			     <div id="dialog" title="问卷调查">
				  <iframe noresize="" id="subjectRel" name="subjectRel" 
				  scrolling="yes" style="width: 100%;height: 95%;border: 0;"></iframe>
				</div>
			</div>
			
			<div class="page_other_msg right">
				<jsp:include flush="true" page="/qiantai/inc/incLeft.jsp"></jsp:include>
			</div>
		</div>
		
		<div class="foot">
		   <jsp:include flush="true" page="/qiantai/inc/incFoot.jsp"></jsp:include>
	    </div>
	</body>
</html>
