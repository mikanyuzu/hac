/**
 * [module]
 * UpdateStoreData.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.service.impl;

import java.util.HashMap;
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
 * 店舗情報更新クラス
 * @author sysusr1
 *
 */
public class UpdateStoreData extends AbstractService{

	/** 業務処理Dao　店舗管理 */
	private AbstractDao storeDao;
	
	/**
	 * 店舗情報更新実行
	 */
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		// 店舗管理No
		String hubMngNo = LogicUtils.getMapValueToString(inputData, ComponentCommonConst.KEY_USRINFO_HUB_MNG_NO);
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(hubMngNo)) {
			throw new HACBusinessException(this.getClass().getName() + ":00001", "", "店舗管理No");
		}
		
		// 店舗名
		String hubName = LogicUtils.getMapValueToString(inputData, "hub_name");
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(hubName)) {
			throw new HACBusinessException(this.getClass().getName() + ":00001", "", "店舗名");
		}
		
		// 店舗TEL
		String hubTel = LogicUtils.getMapValueToString(inputData, "hub_tel");
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(hubTel)) {
			throw new HACBusinessException(this.getClass().getName() + ":00001", "", "店舗TEL");
		}
		
		// 更新ユーザ
		String updateUser = LogicUtils.getMapValueToString(inputData, "update_user");
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(updateUser)) {
			throw new HACBusinessException(this.getClass().getName() + ":00001", "", "更新ユーザ");
		}
		
		// 店舗情報更新
		storeDao.executeUpdate(inputData, "updateStoreInfoByHubMngNo");
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
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
