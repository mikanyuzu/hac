/**
 * [module]
 * CustmerRegistExecuteFacade.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.facade.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hac.common.ComponentCommon;
import org.hac.common.ComponentCommonConst;
import org.hac.exception.HACBusinessException;
import org.hac.model.impl.CustmerModel;
import org.tsrvfw.common.message.MessageConfigManager;
import org.tsrvfw.common.util.DateUtils;
import org.tsrvfw.common.util.LogicUtils;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.constant.CommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.facade.AbstractFacade;
import org.tsrvfw.model.AbstractModel;
import org.tsrvfw.service.AbstractService;

/**
 * 顧客マスタ登録業務処理クラス
 *
 * @author tsubaki
 *
 */
public class CustmerRegistExecuteFacade extends AbstractFacade {

	/** 業務処理コンポーネント　必須チェック */
	private AbstractService requireCheck;
	
	/** 業務処理コンポーネント　形式チェック */
	private AbstractService formatCheck;
	
	/** 業務処理コンポーネント　顧客マスタ登録 */
	private AbstractService registCustmer;
	
	/** 業務処理コンポーネント　顧客マスタ検索 */
	private AbstractService searchCustmer;
	
	/** 入力値チェックコンポーネント */
	private AbstractService inputRequireCheck;
	
	/**
	 * 顧客マスタ登録業務処理実行
	 */
	@Override
	protected Map<String, Object> executeBusiness(AbstractModel model)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		
		// 必須チェック
		this.valildate(model);
		
		// 相関チェック
		this.correlativeValidate((CustmerModel)model);
		
		// 完了後のメッセージを初期化する
		String message = MessageConfigManager.getViewMessageFromInnerCode(this.getClass().getName() + ":00001");
		
		// 重複確認を実施する ひとまず登録するが、メッセージを変更しておく
		if (this.isOverlap((CustmerModel)model)){
			message = MessageConfigManager.getViewMessageFromInnerCode(this.getClass().getName() + ":00003");
			model.setErrType(CommonConst.ERROR_TYPE_W);
			model.setIsError(true);
		}
		
		// 登録処理を実施する
		this.executeRegist((CustmerModel)model);
		
		// メッセージを格納
		model.setAppMessage(message);
		
		// 処理結果Map生成
		Map<String, Object> facadeResultMap = new HashMap<String, Object>();
		facadeResultMap.put(ActionCommonConst.RESULT_CODE,
				ActionCommonConst.RESULT_SUCCESS);
		return facadeResultMap;
	}

	/**
	 * 業務エラー発生処理
	 */
	@Override
	public Map<String, Object> executeBusinessException()
			throws TsrvfwSystemException {
		
		// 処理結果Map生成
		Map<String, Object> facadeResultMap = new HashMap<String, Object>();
		facadeResultMap.put(ActionCommonConst.RESULT_CODE,
				ActionCommonConst.BUSINESS_ERR);
		return facadeResultMap;
	}
	
	/**
	 * 業務処理コンポーネント　必須チェック
	 * @param service　業務処理コンポーネント　必須チェック
	 */
	public void setRequireCheck(AbstractService service) {
		this.requireCheck = service;
	}
	
	/**
	 * 業務処理コンポーネント　顧客マスタ検索
	 * @param service　業務処理コンポーネント　顧客マスタ検索
	 */
	public void setSearchCustmer(AbstractService service) {
		this.searchCustmer = service;
	}
	
	/**
	 * 業務処理コンポーネント　形式チェック
	 * @param formatCheck 業務処理コンポーネント　形式チェック
	 */
	public void setFormatCheck(AbstractService service) {
		this.formatCheck = service;
	}

	/**
	 * 業務処理コンポーネント　顧客マスタ登録設定
	 * @param registCustmer 業務処理コンポーネント　顧客マスタ登録
	 */
	public void setRegistCustmer(AbstractService service) {
		this.registCustmer = service;
	}
	
	/**
	 * 業務処理コンポーネント　入力チェックインスタンス設定
	 * 
	 * @param service  業務処理コンポーネント　入力チェックインスタンス設定
	 */
	public void setInputRequireCheck(AbstractService service) {
		this.inputRequireCheck = service;
	}
	
	/**
	 * 必須入力チェック実行
	 * @param model
	 * @throws TsrvfwBusinessException 
	 * @throws TsrvfwSystemException 
	 */
	private void valildate(AbstractModel model)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		CustmerModel inputModel = (CustmerModel) model;
		
		// ふりがな（姓）
		Map<String, Object> custmerNameFirstReadMap = ComponentCommon
				.editDataMap(inputModel.getCustmerNameFirstRead(),
						"20",
						"1",
						"custmerNameFirstRead", "ふりがな（姓）");
		requireCheck.execute(custmerNameFirstReadMap);
		
		// ふりがな（名）
		Map<String, Object> custmerNameLastReadMap = ComponentCommon
				.editDataMap(inputModel.getCustmerNameLastRead(),
						"20",
						"1",
						"custmerNameLastRead", "ふりがな（名）");
		requireCheck.execute(custmerNameLastReadMap);
		
		// 性別
		Map<String, Object> custmerGenderMap = ComponentCommon
				.editDataMap(inputModel.getCustmerGender(),
						"1",
						"2",
						"custmerGender", "性別");
		formatCheck.execute(custmerGenderMap);
		
		// 年齢
		Map<String, Object> custmerAgeMap = ComponentCommon
				.editDataMap(inputModel.getCustmerAge(),
						"3",
						"2",
						"custmerAge", "年齢");
		formatCheck.execute(custmerAgeMap);
		
		// TEL1
		Map<String, Object> custmerTelMap = ComponentCommon
				.editDataMap(inputModel.getCustmerTel(),
						"12",
						"2",
						"custmerTel", "TEL１（自宅）");
		formatCheck.execute(custmerTelMap);
		
		// TEL2
		Map<String, Object> custmerTelCellMap = ComponentCommon
				.editDataMap(inputModel.getCustmerTelCell(),
						"12",
						"2",
						"custmerTelCell", "TEL１（携帯）");
		formatCheck.execute(custmerTelCellMap);
		
		// Eメールアドレス(個人)
		Map<String, Object> custmerEmailMap = ComponentCommon
				.editDataMap(inputModel.getCustmerEmail(),
						"50",
						"4",
						"custmerEmail", "Eメールアドレス（個人）");
		formatCheck.execute(custmerEmailMap);
		
		// 勤務先（連絡先）
		Map<String, Object> custmerEmploymentTelMap = ComponentCommon
				.editDataMap(inputModel.getCustmerEmploymentTel(),
						"12",
						"2",
						"custmerEmploymentTel", "勤務先（連絡先）");
		formatCheck.execute(custmerEmploymentTelMap);
		
		// Eメールアドレス(会社)
		Map<String, Object> custmerEmploymentEmailMap = ComponentCommon
				.editDataMap(inputModel.getCustmerEmploymentEmail(),
						"50",
						"4",
						"custmerEmploymentEmail", "Eメールアドレス（会社）");
		formatCheck.execute(custmerEmploymentEmailMap);
		
		// メールマガジン配信先
		Map<String, Object> sendEmailTypeMap = ComponentCommon
				.editDataMap(inputModel.getSendEmailType(),
						"1",
						"2",
						"sendEmailType", "メールマガジン配信先");
		formatCheck.execute(sendEmailTypeMap);
		
		// カード会員種類
		Map<String, Object> memberTypeMap = ComponentCommon
				.editDataMap(inputModel.getMemberType(),
						"2",
						"2",
						"memberType", "カード会員種類");
		formatCheck.execute(memberTypeMap);
		
		// カード会員番号		
		Map<String, Object> memberDistMap = ComponentCommon
				.editDataMap(inputModel.getMemberDist(),
						"10",
						"2",
						"memberDist", "カード会員番号");
		formatCheck.execute(memberDistMap);
	}
	
	/**
	 * 入力相関チェックを行う
	 * @param model 入力値
	 * @throws TsrvfwSystemException 想定外システムエラー発生時
	 * @throws TsrvfwBusinessException チェックNGの場合
	 */
	private void correlativeValidate(CustmerModel model) throws TsrvfwSystemException, TsrvfwBusinessException{
		Map<String, Object> inputData = new HashMap<String, Object>();
		Map<String, Object> inputDatas = new HashMap<String, Object>();
		inputDatas.put("CustmerTel", model.getCustmerTel());
		inputDatas.put("CustmerTelCell", model.getCustmerTelCell());
		inputData.put(ComponentCommonConst.KEY_INPUT_CHECK_DATA, inputDatas);
		inputData.put(ComponentCommonConst.KEY_INPUT_CHECK_CONDITION, ComponentCommonConst.KEY_INPUT_CHECK_CONDITION_OR);
		Map<String, Object> checkResult = inputRequireCheck.execute(inputData);
		// チェックNGの場合
		if (ComponentCommonConst.KEY_INPUT_CHECK_NG.equals(checkResult.get(ComponentCommonConst.KEY_INPUT_CHECK_RESULT))){
			throw new HACBusinessException(this.getClass().getName() + ":00002", "", null);
		}
	}
	
	/**
	 * 顧客マスタ登録実行
	 * @param model 入力値
	 * @throws TsrvfwSystemException 想定外システムエラーの場合
	 * @throws TsrvfwBusinessException 登録処理に失敗下場合
	 */
	private void executeRegist(CustmerModel model) throws TsrvfwSystemException, TsrvfwBusinessException{
		Map<String, Object> registCustmerInputMap = new HashMap<String, Object>();
		String hubMngNo = model.getHubMngNo();
		String hubMngDist = hubMngNo.substring(0, 3);
		registCustmerInputMap.put("hub_mng_no", hubMngNo);
		registCustmerInputMap.put("hub_mng_dist", hubMngDist + "C");
		registCustmerInputMap.put("custmer_name_first", model.getCustmerNameFirst());
		registCustmerInputMap.put("custmer_name_last", model.getCustmerNameLast());
		registCustmerInputMap.put("custmer_name_first_read", model.getCustmerNameFirstRead());
		registCustmerInputMap.put("custmer_name_last_read", model.getCustmerNameLastRead());
		registCustmerInputMap.put("custmer_gender", model.getCustmerGender());
		registCustmerInputMap.put("custmer_age", model.getCustmerAge());
		registCustmerInputMap.put("custmer_address1", model.getCustmerAddress1());
		registCustmerInputMap.put("custmer_address2", model.getCustmerAddress2());
		registCustmerInputMap.put("custmer_address3", model.getCustmerAddress3());
		registCustmerInputMap.put("custmer_tel", model.getCustmerTel());
		registCustmerInputMap.put("custmer_tel_cel", model.getCustmerTelCell());
		registCustmerInputMap.put("custmer_email", model.getCustmerEmail());
		registCustmerInputMap.put("custmer_employment", model.getCustmerEmployment());
		registCustmerInputMap.put("custmer_employment_tel", model.getCustmerEmploymentTel());
		registCustmerInputMap.put("custmer_employment_email", model.getCustmerEmploymentEmail());
		registCustmerInputMap.put("send_email_type", model.getSendEmailType());
		registCustmerInputMap.put("first_visit_date", DateUtils.editStringDateToUnixTimestamp(model.getFristVisitDate(), "-"));
		registCustmerInputMap.put("member_type", model.getMemberType());
		registCustmerInputMap.put("member_dist", model.getMemberDist());
		
		long nowTime = DateUtils.getSystemDateUnixTimestamp();
		registCustmerInputMap.put("custmer_regist_date", nowTime);
		registCustmerInputMap.put("update_user", model.getUserId());
		registCustmerInputMap.put("create_user", model.getUserId());
		registCustmer.execute(registCustmerInputMap);
	}
	
	/**
	 * 顧客データの重複チェックを行う
	 * 
	 * @param model
	 * @return
	 * @throws TsrvfwSystemException
	 * @throws TsrvfwBusinessException
	 */
	@SuppressWarnings("unchecked")
	private boolean isOverlap(CustmerModel model) throws TsrvfwSystemException, TsrvfwBusinessException{
		boolean result = false;
		// 	顧客マスタを検索する
		Map<String, Object> custmerSearchConditions = new HashMap<String, Object>();
		custmerSearchConditions.put("hub_mng_no", model.getHubMngNo());
		if (LogicUtils.isNotEmptyString(model.getCustmerTel())){
			custmerSearchConditions.put("custmer_tel", model.getCustmerTel());
		}
		else if (LogicUtils.isNotEmptyString(model.getCustmerTelCell())){
			custmerSearchConditions.put("custmer_tel_cell", model.getCustmerTelCell());
		}
		custmerSearchConditions.put("custmer_gender", "0");
		custmerSearchConditions.put("custmer_address1", "0");
		custmerSearchConditions.put("send_email_type", "0");
		custmerSearchConditions.put("member_type", "0");
		// 検索実行
		Map<String, Object> custmerSearchResult = searchCustmer.execute(custmerSearchConditions);
		List<Map<String,Object>> resultList = (List<Map<String,Object>>)custmerSearchResult.get("select_result");
		// 重複している可能性我ある場合はメッセージ変更する
		if (resultList.size() > 0){
			result = true;
		}
		return result;
	}
}

