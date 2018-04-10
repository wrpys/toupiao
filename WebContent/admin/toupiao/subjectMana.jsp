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
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/jquery-ui.css" />
        <script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="<%=path %>/js/jquery-ui.js"></script>
		<script type="text/javascript" src="<%=path %>/js/public.js"></script>
		
        <script language="javascript">
	        function updateSubject(id) {
	        	
	        }
	        function deleteSubject(id) {
	        	var r=confirm("确认删除吗？")
        	    if (r==true) {
        	    	var strUrl="<%=path %>/toupiaoDelete.action?wenjuan_id=${wenjuanId}&mingchengType=${mingchengType}&id=" + id;
                    window.location.href=strUrl;
        	    }
	        }
	        function addSubject() {
	        	var strUrl="<%=path %>/admin/toupiao/toupiaoAdd.jsp?wenjuan_id=${wenjuanId}&mingchengType=${mingchengType}";
                window.location.href=strUrl;
	        }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="33" background="<%=path %>/img/tbg.gif">&nbsp;题目管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="10%">ID</td>
					<td width="45%">题目名称</td>
					<td width="15%">类型</td>
					<td width="25%">操作</td>
		        </tr>	
				<c:forEach items="${subjectList}" var="subject" varStatus="ss">
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
						<c:if test="${subject.type==2}">多选</c:if>
						<c:if test="${subject.type==3}">文本</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a style="color: red" href="#" onclick="updateSubject(${subject.id})">修改</a>
						<a style="color: red" href="#" onclick="deleteSubject(${subject.id})">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="addSubject()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
