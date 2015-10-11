<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div class="commonMessagefield">
	メッセージ：&nbsp;&nbsp;
	<s:if test="%{isError}">
		<s:if test="%{errType == 2}">
			<span class="messageStringsWarn"><s:property value="appMessage"  /></span>
		</s:if>
		<s:else>
			<span class="messageStringsError"><s:property value="appMessage"  /></span>
		</s:else>
	</s:if>
	<s:else>
		<span class="messageStringsNormal"><s:property value="appMessage"  /></span>
	</s:else>
</div>