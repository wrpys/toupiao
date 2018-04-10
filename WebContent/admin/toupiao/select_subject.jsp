<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
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

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/js/public.js"></script>
		
        <script language="javascript">
           function selectSubject(id) {
        	   parent.currentSubjectRelId.val(id);
        	   parent.$("#dialog").dialog("close");
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="33" background="<%=path %>/img/tbg.gif">&nbsp;题目列表&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="10%">ID</td>
					<td width="40%">题目标题</td>
					<td width="20%">类型</td>
					<td width="25%">操作</td>
		        </tr>	
				<c:forEach items="${requestScope.subjectList}" var="subject" varStatus="ss">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						${ss.index+1}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${subject.id}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						${subject.title}
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:if test="${subject.type==1}">单选</c:if>
						<c:if test="${subject.type==3}">文本</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a style="color: red" href="#" onclick="selectSubject(${subject.id})">选择</a>
					</td>
				</tr>
				</c:forEach>
			</table>
	</body>
</html>
