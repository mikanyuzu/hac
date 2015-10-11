/**
 * [module]
 * StoresInfoLookup.java
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
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.service.AbstractService;

/**
 * 店舗情報取得処理クラス
 * @author sysusr1
 *
 */
public class StoresInfoLookup extends AbstractService {

	/** 会社情報Dao */
	private AbstractDao orgDao;
	
	/**
	 * 店舗情報取得処理
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		// 会社管理No
		String orgMngNo = LogicUtils.getMapValueToString(inputData, ComponentCommonConst.KEY_USRINFO_ORG_MNG_NO);
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(orgMngNo)){
			throw new HACBusinessException(this.getClass().getName() + ":00001", "", "");
		}
		
		// 会社管理Noから登録されている店舗情報を取得する
		Map<String, Object> existHubMngNoResultMap = orgDao.executeSelect(inputData, "selectHubInfoByOrgMngNo");
		List<Map<String, Object>> existHubMngNoResultDataList = (List<Map<String, Object>>)existHubMngNoResultMap.get("select_result");
		if (existHubMngNoResultDataList.size() == 0){
			throw new HACBusinessException(this.getClass().getName() + ":00002", "", "会社管理No");
		}
		
		// 結果Map作成
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("stores_data", existHubMngNoResultMap);
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
