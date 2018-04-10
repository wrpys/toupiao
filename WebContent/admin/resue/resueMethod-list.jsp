<%@ page language="java" pageEncoding="UTF-8"%>
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

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		
        <script language="javascript">
           function resueDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/resueMethodDel.action?id="+id;
               }
           }
           
           function resueAdd()
           {
                 var url="<%=path %>/admin/resue/resueAdd.jsp";
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/img/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="5" background="<%=path %>/img/tbg.gif">&nbsp;常用救助方法管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="5%">序号</td>
					<td width="13%">方法名称</td>
					<td width="60%">方法介绍</td>
					<td width="12%">创建时间</td>
					<td width="10%">操作</td>
		        </tr>	
				<c:forEach var="resue" items="${list }" varStatus="status">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">${status.index + 1}</td>
					<td bgcolor="#FFFFFF" align="center">${resue.methodName }</td>
					<td bgcolor="#FFFFFF" align="center">
					<c:set var="string2" value="${fn:trim(resue.contentInfo)}" />
				
					<c:if test="${fn:length(string2)>400 }">
					 ${fn:substring(string2, 0, 400)}......
					</c:if>
					<c:if test="${fn:length(string2)<=400 }">
					  ${resue.contentInfo}
					</c:if>
					</td>
					<td bgcolor="#FFFFFF" align="center">${resue.createTime }</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="resueDel('${resue.id}')" class="pn-loperator">删除</a>
					</td>
				</tr>
				</c:forEach>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="resueAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
