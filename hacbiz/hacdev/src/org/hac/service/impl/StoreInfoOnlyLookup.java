/**
 * [module]
 * StoreInfoOnlyLookup.java
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
 * 自店舗情報取得クラス
 * @author sysusr1
 *
 */
public class StoreInfoOnlyLookup extends AbstractService{

	/** 業務処理Dao　店舗管理 */
	private AbstractDao storeDao;
	
	/**
	 * 自店舗情報取得実行
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		
		// 店舗管理No
		String hubMngNo = LogicUtils.getMapValueToString(inputData, ComponentCommonConst.KEY_USRINFO_HUB_MNG_NO);
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(hubMngNo)) {
			throw new HACBusinessException(this.getClass().getName() + ":00001", "", "");
		}
		Map<String, Object> selectStoreByHubMngNoResultMap = storeDao.executeSelect(inputData, "selectStoreByHubMngNo");
		List<Map<String, Object>> selectStoreByHubMngNoResultDataList = (List<Map<String, Object>>)selectStoreByHubMngNoResultMap.get("select_result");
		if (selectStoreByHubMngNoResultDataList.size() == 0){
			throw new HACBusinessException(this.getClass().getName() + ":00002", "", "");
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("stores_data", selectStoreByHubMngNoResultMap);
		resultMap.put(ActionCommonConst.RESULT_CODE, ActionCommonConst.RESULT_SUCCESS);
		return resultMap;
	}
	
	/**
	 * 業務処理Dao　店舗管理 インスタンス設定
	 * @param dao 業務処理Dao　店舗管理
	 */
	public void setStoreDao(AbstractDao dao) {
		this.storeDao = dao;
	}

}
