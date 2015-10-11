<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="mainMenubar">
	<div class="commonTitle">
		【業務メニュー】
	</div>
	<div class="commonSimpleSearchAreaButton">
		<s:submit action="CustmerMng" cssClass="buttonCss2button workButton" id="" value="顧客管理" />
		<s:submit action="VisitRecordMng" cssClass="buttonCss2button workButton" id="" value="来店履歴" />
		<s:submit action="ReserveMng" cssClass="buttonCss2button workButton" id="" value="予約管理" />
	</div>
	<div class="commonSimpleSearchAreaButton">
		<s:submit action="PromotionMng" cssClass="buttonCss2button workButton" id="" value="販売促進" />
		<s:submit action="SysUserMng" cssClass="buttonCss2button maintenanceButton" id="" value="ユーザ情報" />
		<s:submit action="OrgMng" cssClass="buttonCss2button maintenanceButton" id="" value="会社情報" />
	</div>
</div>