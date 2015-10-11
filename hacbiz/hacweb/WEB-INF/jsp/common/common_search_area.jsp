<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="commonSimpleSearchArea">
	<div class="commonTitle">
		【簡易検索】
	</div>
	<div>
		<s:submit action="SimpleSearch" cssClass="buttonCss2button" id="simpleSearchButton" value="検索する" />
	</div>
	<div>
		氏名：
		<s:textfield name="simpleSearchName" label="氏名"></s:textfield>
		電話番号：
		<s:textfield name="simpleSearchTel" label="電話番号"></s:textfield>
	</div>
</div>