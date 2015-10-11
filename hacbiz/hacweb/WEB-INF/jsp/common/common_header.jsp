<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div class="commonHeader">
	<div class="commonHeadertitle">
		社内システム
	</div>
	<div class="commonLoginInfo">
		<b>ユーザ</b>：<s:text name="userAccount" />&nbsp;&nbsp;<b>ログイン</b>：<s:text name="loginTime" />&nbsp;&nbsp;
		<s:submit action="EntranceLogout" cssClass="buttonCss1button" id="logoutButton" value="ログアウト"  onclick="return  confirmLogout(); "/>
	</div>
</div>
<div class="commonHeaderUnderLine">
	<hr>
</div>