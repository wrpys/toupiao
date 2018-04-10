<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  
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
	</head>

	<body>
		<jsp:include flush="true" page="/qiantai/inc/incTop.jsp"></jsp:include>
		<div class="page_row">
			<div class="page_main_msg left">
			     <div class="left_row">
		              <div class="list pic_news">
				          <div class="list_bar">志愿者列表</div>
				          <div class="list_content" style="height: 445px;">
                              <div class="c1-body">
                       <c:forEach var="vol" items="${list}" varStatus="status">
                                  <div class="c1-bline" style="padding:7px 0px;">
                                       <div class="f-left">
                                            <img src="<%=path %>/img/head-mark4.gif" align="middle" class="img-vm" border="0"/> 
                                             &nbsp;&nbsp; ${vol.userName} (${vol.userSex })
                                            <a style="margin-left: 80px;" target="blank" href="tencent://message/?uin=${vol.userQq }&Site=qq&Menu=yes">
                                            <img border="0" src="/toupiao/img/pa.gif" alt="咨询" height="20px"></a>
                                       </div>
                                       <div class="f-right"></div>
                                       <div class="clear"></div>
                                  </div>
                                  </c:forEach>
								  <div class="pg-3">
									   <!--  分页-->
								  </div>		  
						      </div>
						  </div>
					  </div>	
				      <div style="clear:both;"></div>
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
