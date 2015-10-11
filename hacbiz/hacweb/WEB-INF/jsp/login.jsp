<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<s:include value="/WEB-INF/jsp/common/common_meta_info.jsp"></s:include>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/Static/css/login.css">
<title>HAC</title>
</head>
<body>
	<s:form method="POST">
		<s:include value="/WEB-INF/jsp/common/common_header_no_login.jsp"></s:include>
		<s:include value="/WEB-INF/jsp/common/common_message_area.jsp"></s:include>
		<s:property value="displayCode" />
		<div class="subTitle">ログイン</div>
		<div class="mainContainer">
			<p>
				店舗管理No
				<s:textfield name="hubMngNo" label="店舗管理No" value="" size="15" maxlength="10"/>
			</p>
			<p>
				ユーザID
				<s:textfield name="userId" label="ユーザID" value="" size="15" maxlength="10" />
			</p>
			<p>
				パスワード
				<s:password name="pwd" label="パスワード" value="" size="15"  maxlength="10"/>
			</p>
			<br>
			<p>
				<s:submit action="EntranceLogin" cssClass="buttonCss2button" id="loginButton" value="ログイン" />
			</p>
			<br>
		</div>
	</s:form>
</body>
</html>