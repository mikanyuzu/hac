/**
 * [module]
 * AbstractAction.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.facade.impl;

import java.util.HashMap;
import java.util.Map;

import org.hac.common.ComponentCommonConst;
import org.hac.exception.HACBusinessException;
import org.hac.model.impl.LoginModel;
import org.tsrvfw.common.message.MessageConfigManager;
import org.tsrvfw.common.util.DateUtils;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.facade.AbstractFacade;
import org.tsrvfw.model.AbstractModel;
import org.tsrvfw.service.AbstractService;

/**
 * ログイン業務処理クラス
 * 
 * @author tsubaki
 * 
 */
public class EntranceLoginFacade extends AbstractFacade {

	/** 業務処理コンポーネント　ユーザ情報チェック */
	private AbstractService checkUserInfo;
	
	/** 業務処理コンポーネント　入力値チェック */
	private AbstractService inputRequireCheck;

	/**
	 * ログイン業務処理実行
	 * @param model
	 *            画面入力値保持クラス
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeBusiness(AbstractModel model)
			throws TsrvfwSystemException, TsrvfwBusinessException {

		// 入力値をMapに詰める
		Map<String, Object> inputData = new HashMap<String, Object>();
		Map<String, Object> inputDatas = new HashMap<String, Object>();
		inputDatas.put("hub_mng_no", ((LoginModel)model).getHubMngNo());
		inputDatas.put("user_id", ((LoginModel)model).getUserId());
		inputDatas.put("user_passwd", ((LoginModel)model).getPwd());
		inputData.put(ComponentCommonConst.KEY_INPUT_CHECK_DATA, inputDatas);
		inputData.put(ComponentCommonConst.KEY_INPUT_CHECK_CONDITION, ComponentCommonConst.KEY_INPUT_CHECK_CONDITION_AND);
		// チェック結果
		Map<String, Object> checkResult = inputRequireCheck.execute(inputData);
		// チェックNGの場合
		if (ComponentCommonConst.KEY_INPUT_CHECK_NG.equals(checkResult.get(ComponentCommonConst.KEY_INPUT_CHECK_RESULT))){
			throw new HACBusinessException(this.getClass().getName() + ":00002", "", "");
		}
		
		// ユーザ情報をチェックする
		Map<String, Object> checkUserInfoResult = checkUserInfo.execute(inputDatas);
		// チェックNGの場合
		if (ComponentCommonConst.KEY_INPUT_CHECK_NG.equals(checkUserInfoResult.get(ComponentCommonConst.KEY_INPUT_CHECK_RESULT))){
			throw new HACBusinessException(this.getClass().getName() + ":00002", "", "");
		}
		// チェック後のユーザデータを格納
		Map<String, Object> userData = (Map<String, Object>)checkUserInfoResult.get("user_data");
		((LoginModel)model).setUserAccount((String)userData.get("user_name"));
		((LoginModel)model).setHubMngNo((String)userData.get("hub_mng_no"));
		((LoginModel)model).setLoginTime(DateUtils.getFormatDate(DateUtils.getSystemDate(), DateUtils.DATE_FORMAT_FULL) );
		
		// メッセージを格納
		model.setAppMessage(MessageConfigManager.getViewMessageFromInnerCode(this.getClass().getName() + ":00001"));
		// 処理結果Map生成
		Map<String, Object> facadeResultMap = new HashMap<String, Object>();
		facadeResultMap.put(ActionCommonConst.RESULT_CODE,
				ActionCommonConst.RESULT_SUCCESS);
		return facadeResultMap;
	}

	/**
	 * 業務処理コンポーネント　ユーザ情報チェック
	 * @param service　業務処理コンポーネント　ユーザ情報チェック
	 */
	public void setCheckUserInfo(AbstractService service) {
		this.checkUserInfo = service;
	}
	
	/**
	 * 業務処理コンポーネント　入力値チェック
	 * @param service　業務処理コンポーネント　入力値チェック
	 */
	public void setInputRequireCheck(AbstractService service) {
		this.inputRequireCheck = service;
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

}
