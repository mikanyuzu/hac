<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<script>
$(function() {
	$("#addConditionButton").click(function () {
		var selectedId = $("#addConditionSelect").val();
		if (selectedId != "default"){
			var selectedConditionNode = $("#" + selectedId).html();
			$(".conditionArea").append("<div>" + selectedConditionNode + "</div>");
			$("#addConditionSelect").children("option[value=" + selectedId + "]").remove();
		}
	});
});
</script>
<div>
	<div class="commonTitle mainAreaSubTitle">
		＜検索条件＞
	</div>
	<div class="conditionArea">
		<div class="addConditions">
			<select id="addConditionSelect">
				<option value="default">--検索条件を選択する--</option>
				<option value="custmerAddress1">住所（都道府県）</option>
				<option value="custmerAddress2">住所（市町村区）</option>
				<option value="custmerAddress3">住所（その他）</option>
				<option value="custmerEmail">Eメールアドレス（個人）</option>
				<option value="custmerEmployment">勤務先（会社名）</option>
				<option value="custmerEmploymentTel">勤務先（連絡先）</option>
				<option value="custmerEmploymentEmail">Eメールアドレス（会社）</option>
				<option value="sendEmailType">メールマガジン配信先</option>
				<option value="fristVisitDate">初回来店日</option>
				<option value="custmerRegistDate">顧客登録日</option>
				<option value="memberType">カード会員種類</option>
				<option value="memberDist">カード会員番号</option>
			</select>
			<input type="button" value="条件を追加" id="addConditionButton"/>
		</div>
		<div class="defaultConditions">
			顧客管理No
			<s:textfield name="custmerMngNo" label="custmerMngNo" size="15" maxlength="10" />
		</div>
		<div>
			氏名（姓）
			<s:textfield name="custmerNameFirst" label="custmer_name_first" size="15" maxlength="6" />
			ふりがな（姓）
			<s:textfield name="custmerNameFirstRead" label="custmer_name_first_read" size="30" maxlength="20" />
		</div>
		<div>
			氏名（名）
			<s:textfield name="custmerNameLast" label="custmer_name_last" size="15" maxlength="6" />
			ふりがな（名）
			<s:textfield name="custmerNameLastRead" label="custmer_name_Last_read" size="30" maxlength="20" />
		</div>
		<div>
			TEL（自宅）
			<s:textfield name="custmerTel" label="custmer_tel" size="30" maxlength="12" />
			TEL（携帯）
			<s:textfield name="custmerTelCell" label="custmer_tel_cell" size="30" maxlength="12" />
		</div>
		<div>
			性別
			<s:select name="custmerGender" label="custmer_gender" value="0" list="#{'0':'未選択' ,'1':'男', '2':'女'}" />
			年齢
			<s:textfield name="custmerAge" label="custmer_age" size="10" maxlength="3" />
		</div>
	</div>
	<br>
	<div class="selectResultArea">
		<div class="commonTitle mainAreaSubTitle">
			＜検索結果＞
		</div>
		<div class="selectResultAreaDetail">
			<s:if test="%{custmerDataMapList != null}">
				<table class="selectResultDataList">
			       <tr id="">
			           <th id="">No</th>
			           <th id="">顧客管理No</th>
			           <th id="">ふりがな（姓）</th>
			           <th id="">ふりがな（名）</th>
			           <th id="">性別</th>
			           <th id="">TEL（自宅）</th>
			           <th id="">TEL（携帯）</th>
			       </tr>
					<s:iterator value="custmerDataMapList" status="custmerDataMap">
						<tr>
							<td class="" >
								<s:property value="#custmerDataMap.index + 1" />
							</td>
							<td class="" >
								<s:a href="#" onclick="">
									<s:property value="%{custmer_mng_no}" />
								</s:a></td>
							<td class="" >
								<s:property value="%{custmer_name_first_read}" />
							</td>
							<td class="" >
								<s:property value="%{custmer_name_last_read}" />
							</td>
							<td class="" >
								<s:property value="%{custmer_gender}" />
							</td>
							<td class="" >
								<s:property value="%{custmer_tel}" />
							</td>
							<td class="" >
								<s:property value="%{custmer_tel_cel}" />
							</td>
						</tr>
					</s:iterator>
				</table>
		   </s:if>
	   </div>
	</div>
	<div class="alphaSearchCondition">
		<div id="custmerAddress1" >
			住所（都道府県）
			<s:select name="custmerAddress1" label="custmer_address1" value="0" list="#{'0':'未選択', '1':'北海道', '2':'青森県', '3':'岩手県', '4':'宮城県', '5':'秋田県', '6':'山形県', '7':'福島県', '8':'茨城県', '9':'栃木県', '10':'群馬県', '11':'埼玉県', '12':'千葉県', '13':'東京都', '14':'神奈川県', '15':'新潟県', '16':'富山県', '17':'石川県', '18':'福井県', '19':'山梨県', '20':'長野県', '21':'岐阜県', '22':'静岡県', '23':'愛知県', '24':'三重県', '25':'滋賀県', '26':'京都府', '27':'大阪府', '28':'兵庫県', '29':'奈良県', '30':'和歌山県', '31':'鳥取県', '32':'島根県', '33':'岡山県', '34':'広島県', '35':'山口県', '36':'徳島県', '37':'香川県', '38':'愛媛県', '39':'高知県', '40':'福岡県', '41':'佐賀県', '42':'長崎県', '43':'熊本県', '44':'大分県', '45':'宮崎県', '46':'鹿児島県', '47':'沖縄県'}" />
		</div>
		<div id="custmerAddress2" >
			住所（市町村区）
			<s:textfield name="custmerAddress2" label="custmer_address2" size="30" maxlength="10" />
		</div>
		<div id="custmerAddress3">
			住所（その他）
			<s:textfield name="custmerAddress3" label="custmer_address3" size="50" maxlength="50" />
		</div>
		<div id="custmerEmail">
			Eメールアドレス（個人）
			<s:textfield name="custmerEmail" label="custmer_email" size="50" maxlength="50" />	
		</div>
		<div id="custmerEmployment">
			勤務先（会社名）
			<s:textfield name="custmerEmployment" label="custmer_employment" size="50" maxlength="50" />	
		</div>
		<div id="custmerEmploymentTel">
			勤務先（連絡先）
			<s:textfield name="custmerEmploymentTel" label="custmer_employment_tel" size="30" maxlength="12" />
		</div>
		<div id="custmerEmploymentEmail">
			Eメールアドレス（会社）
			<s:textfield name="custmerEmploymentEmail" label="custmer_employment_email" size="50" maxlength="50" />	
		</div>
		<div id="sendEmailType">
			メールマガジン配信先
			<s:select name="sendEmailType" label="send_email_type" value="0" list="#{'0':'未選択', '1':'なし', '2':'個人', '3':'会社'}" />
		</div>
		<div id="fristVisitDate">
			初回来店日
			<sj:datepicker name="fristVisitDate" id="fristVisitDate" displayFormat="yy-mm-dd"/>
		</div>
		<div id="custmerRegistDate">
			顧客登録日
			<sj:datepicker name="custmerRegistDate" id="custmerRegistDate" displayFormat="yy-mm-dd"/>
		</div>
		<div id="memberType">
			カード会員種類
			<s:select name="memberType" label="member_type" value="0" list="#{'0':'未選択', '1':'ゴールド', '2':'プラチナ'}" />
		</div>
		<div id="memberDist">
			カード会員番号
			<s:textfield name="memberDist" label="member_dist" size="10" maxlength="10" />
		</div>
	</div>
</div>