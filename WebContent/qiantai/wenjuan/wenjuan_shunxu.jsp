<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/jquery-ui.css" />
        <script type="text/javascript" src="<%=path %>/js/jquery-1.7.2.min.js"></script>
        <script type="text/javascript" src="<%=path %>/js/jquery-ui.js"></script>
		<style type="text/css">
			*{
				border: 0;
			}
			html {
				height: 95%;
			}
			body {
				height: 98%;
			}
			form {
				height: 100%;
			}
			.main{
				height: 85%;
			}
			.footer {
				border-top: 1px solid #ddd;
				height: 12%;
			}
			.footer button {
				float: right;
				margin-top: 15px;
				margin-right: 20px;
				padding: 6px 10px;
    			background: #3385ff;
			}
			.title {
			    border: 1px solid #ddd;
			    padding: 5px 10px;
			}
			li {
				list-style: none;
				margin-bottom: 8px;
			}
			
		</style>
		<script>
			function selectAnswer(id) {
				if(undefined == id) return ;
				$("#subjectRelId").val(id);
			}
		</script>
	</head>

	<body>
		<form action="<%=path%>/<c:if test="${mingchengType==1}">getTimuByWenjuanId1.action</c:if><c:if test="${mingchengType==2}">getTimuByWenjuanIdOne2.action</c:if>">
			<div class="main">
				<input type="hidden" name="wenjuan_id" value="${subject.wenjuan_id}" />
				<input type="hidden" name="subject_id" value="${subject.id}" />
				<input type="hidden" name="type" value="${subject.type}" />
				<input type="hidden" name="currentWenjuanID" value="${currentWenjuanID}" />
				<input type="hidden" name="mingchengType" value="${mingchengType}" />
				<input type="hidden" id="subjectRelId" name="subjectRelId" />
				<div class="title"><label>题目：</label>${subject.title}</div>
				<c:if test="${subject.type == 1}">
				<ul>
					<c:forEach var="answer" items="${answers}" varStatus="vs">
					<li>
						<label>
							${answer.label}:
						</label>
						<input type="radio" name="answer" value="${answer.id}" onchange="selectAnswer(${answer.toupiao_rel_id});"/>${answer.xuanxiangneirong}
					</li>
					</c:forEach>
				</ul>
				</c:if>
				<c:if test="${subject.type == 2}">
				<ul>
					<c:forEach var="answer" items="${answers}" varStatus="vs">
					<li>
						<label>
							${answer.label}:
						</label>
						<input type="checkbox" name="answer" value="${answer.id}"/>${answer.xuanxiangneirong}
					</li>
					</c:forEach>
				</ul>
				</c:if>
				<c:if test="${subject.type == 3}">
					<textarea rows="15" cols="99" name="text_answer" style="border: 1px solid #ddd;margin-top: 10px;"></textarea>
				</c:if>
			</div>
			<div class="footer">
				<button>确 定</button>
			</div>
		</form>
	</body>
</html>
