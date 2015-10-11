<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="ja">
	<head>
		<s:include value="/WEB-INF/jsp/common/common_meta_info.jsp"></s:include>
		<link rel="stylesheet" href="<%= request.getContextPath() %>/Static/css/login.css">
	</head>
	<body>
		<s:form method="POST">
			<s:include value="/WEB-INF/jsp/common/common_header.jsp"></s:include>
			<div class="subTitle">
				　　
			</div>
			<div class="mainContainer">
				<p>
					システムエラーが発生しました。<br>
					再度ログインを行ってください。<br>
					また、問題が解決されない場合はシステム管理者へ連絡してください。
				</p>
			</div>
		</s:form>
	</body>
</html>
