/**
 * [module]
 * CheckUserInfo.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hac.common.ComponentCommonConst;
import org.hac.exception.HACBusinessException;
import org.tsrvfw.common.util.LogicUtils;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.dao.AbstractDao;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.service.AbstractService;

/**
 * ユーザ情報チェッククラス
 *
 * @author tsubaki
 *
 */
public class CheckUserInfo extends AbstractService {

	/** 会社情報Dao */
	private AbstractDao orgDao;
	
	/**
	 * ユーザ情報のチェックを行う
	 * 
	 * @param ユーザ識別情報
	 * @return 処理結果
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwBusinessException {
		
		// 入力情報の取得
		// ユーザID
		String userId = LogicUtils.getMapValueToString(inputData, ComponentCommonConst.KEY_USRINFO_USER_ID);
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(userId)){
			throw new HACBusinessException(this.getClass().getName() + ":00001", "", "");
		}
		// 店舗管理No
		String hubMngNo = LogicUtils.getMapValueToString(inputData, ComponentCommonConst.KEY_USRINFO_HUB_MNG_NO);
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(hubMngNo)){
			throw new HACBusinessException(this.getClass().getName() + ":00002", "", "");
		}
		// パスワード
		String pwd = LogicUtils.getMapValueToString(inputData, ComponentCommonConst.KEY_USRINFO_PWD);
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(pwd)){
			throw new HACBusinessException(this.getClass().getName() + ":00003", "", "");
		}
		
		// 店舗管理Noを照合する
		Map<String, Object> existHubMngNoResultMap = orgDao.executeSelect(inputData, "existHubMngNo");
		List<Map<String, Object>> existHubMngNoResultDataList = (List<Map<String, Object>>)existHubMngNoResultMap.get("select_result");
		if (existHubMngNoResultDataList.size() == 0){
			throw new HACBusinessException(this.getClass().getName() + ":00004", "", "店舗管理No");
		}
		// ユーザを照合する
		Map<String, Object> existUserResultMap = orgDao.executeSelect(inputData, "existUser");
		List<Map<String, Object>> existUserResultDataList = (List<Map<String, Object>>)existUserResultMap.get("select_result");
		if (existUserResultDataList.size() == 0){
			throw new HACBusinessException(this.getClass().getName() + ":00005", "", "ユーザID、パスワード");
		}
		
		// 結果Map作成
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("user_data", existUserResultDataList.get(0));
		resultMap.put(ActionCommonConst.RESULT_CODE, ActionCommonConst.RESULT_SUCCESS);
		return resultMap;
	}

	/**
	 * 会社情報Daoインスタンス設定
	 * @param orgMst 会社情報Dao
	 */
	public void setOrgDao(AbstractDao dao) {
		this.orgDao = dao;
	}

}

