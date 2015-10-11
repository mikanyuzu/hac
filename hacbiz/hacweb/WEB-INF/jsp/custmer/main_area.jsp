<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<script type="text/javascript">
</script>
<div>
	<div class="mainAreaTitle">
		顧客管理
	</div>
	<div class="executeButton">
		<s:if test="%{workType == 1}">
			<s:submit action="CustmerRegistExecute" id="CustmerRegistExecuteButton" cssClass="buttonCss4button" value="登録する"/>
		</s:if>
		<s:if test="%{workType == 2}">
			<s:submit action="CustmerSearchExecute" cssClass="buttonCss4button" value="検索する"/>
		</s:if>
	</div>
	<div>
		<%-- 登録 --%>
		<s:if test="%{workType == 1}">
			<s:include value="/WEB-INF/jsp/custmer/regist.jsp" />
		</s:if>
		<%-- 検索 --%>
		<s:if test="%{workType == 2}">
			<s:include value="/WEB-INF/jsp/custmer/search.jsp" />
		</s:if>
	</div>
	<sj:dialog id="custmerDegistDialog" autoOpen="false" title="登録確認" modal="true"
		buttons="{
			'OK' : function() {
				registOk();
				$('#custmerDegistDialog').dialog('close');
			},
			'修正する' : function() {
				$('#custmerDegistDialog').dialog('close');
			},
		}"
		>
		登録しますか？<br>
	</sj:dialog>
</div>