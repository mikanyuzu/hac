<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<s:include value="/WEB-INF/jsp/common/common_meta_info.jsp"></s:include>
<link rel="stylesheet" href="<%=request.getContextPath()%>/Static/css/main_display_template1.css">
<sj:head locale="ja" loadAtOnce="true" />
<style type="text/css">
#fade, #loader {
	display: block; 
}
.mainInnerBody {
	overflow: ;
}
.mainContainer{
	display: none;
}
</style>
<script>
$(function(){
	$(document).ready(function(){
		var pageH = '100%';
		$("#fade").css("height", pageH).delay(100).fadeOut(100);
		$("#loader").delay(100).fadeOut(100);
		$(".mainContainer").css("display", "block");
	});
	$('.buttonCss2button .buttonCss3button .buttonCss1button .buttonCss4button').click(function() {
		var pageH = '100%';
		$("#fade").css("height", pageH).delay(10).fadeIn(10);
		$("#loader").delay(10).fadeIn(10);
		$(".mainContainer").css("display", "none");
	});
});
</script>
</head>
<body class="mainInnerBody">
<div id="loader"><img src="<%=request.getContextPath()%>/Static/img/loading/gif-load.gif" width="80px" height="80px" alt="Loading..." /></div>
<div id="fade"></div>
	<s:form method="POST">
		<s:include value="/WEB-INF/jsp/common/common_hidden_area.jsp"></s:include>
		<s:include value="/WEB-INF/jsp/common/common_header.jsp"></s:include>
		<s:include value="/WEB-INF/jsp/common/common_message_area.jsp"></s:include>
		<s:include value="/WEB-INF/jsp/common/common_search_area.jsp"></s:include>
		<s:include value="/WEB-INF/jsp/common/common_hader_menu_bar.jsp"></s:include>
		<%-- メインコンテンツ --%>
		<div class="mainContainer">
			<%-- 業務別サイドメニュー --%>
			<div class="contentsSideMenu">
			<s:if test="%{displayCode != null && displayCode != ''}">
				<s:include value="/WEB-INF/jsp/%{displayCode}/side_menu.jsp"></s:include>
			</s:if>
			</div>
			
			<%-- 業務別メインコンテンツ --%>
			<div class="contentsMeinArea">
				<s:if test="%{displayCode != null && displayCode != ''}">
					<s:include value="/WEB-INF/jsp/%{displayCode}/main_area.jsp"></s:include>
					<s:if test="%{alphaDisplayCode != null && alphaDisplayCode != ''}">
						<s:include value="/WEB-INF/jsp/%{alphaDisplayCode}/main_area.jsp"></s:include>
					</s:if>
				</s:if>
			</div>
			
			<%-- メインコンテンツフッター --%>
			<div class="contentsFooterArea">
			</div>
		</div>
	</s:form>
</body>
</html>