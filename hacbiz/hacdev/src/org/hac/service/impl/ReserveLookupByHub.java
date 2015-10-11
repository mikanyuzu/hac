/**
 * [module]
 * ReserveLookupByHub.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.service.impl;

import java.util.Map;

import org.hac.common.ComponentCommonConst;
import org.hac.exception.HACBusinessException;
import org.tsrvfw.common.util.LogicUtils;
import org.tsrvfw.dao.AbstractDao;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.service.AbstractService;

/**
 * 店舗別予約一覧取得クラス
 * @author sysusr1
 *
 */
public class ReserveLookupByHub extends AbstractService{

	/** 業務処理Dao　予約管理 */
	private AbstractDao reserveDao;
	
	/**
	 * 店舗別予約一覧取得実行
	 */
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		// 店舗管理No
		String hubMngNo = LogicUtils.getMapValueToString(inputData, ComponentCommonConst.KEY_USRINFO_HUB_MNG_NO);
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(hubMngNo)) {
			throw new HACBusinessException(this.getClass().getName() + ":00001", "", "");
		}
		// 検索実行
		Map<String, Object> selectReserveByHubMngNoResultMap = reserveDao.executeSelect(inputData, "selectReserveByHubMngNo");
		return selectReserveByHubMngNoResultMap;
	}
	
	/**
	 * 業務処理Dao　予約管理 インスタンス設定
	 * @param dao 業務処理Dao　予約管理
	 */
	public void setReserveDao(AbstractDao dao) {
		this.reserveDao = dao;
	}

}
