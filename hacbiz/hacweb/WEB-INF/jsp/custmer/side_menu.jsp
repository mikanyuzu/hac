<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<div>
	<div class="commonTitle sideMenuTitle">
		顧客管理
	</div>
	<div class="sideMenu">
		<div class="sideMenuLink">
			<s:submit action="CustmerRegist" cssClass="buttonCss3button" value="登録"/>
		</div>
		<div class="sideMenuLink">
			<s:submit action="CustmerSearch" cssClass="buttonCss3button" value="検索"/>
		</div>
	</div>
</div>