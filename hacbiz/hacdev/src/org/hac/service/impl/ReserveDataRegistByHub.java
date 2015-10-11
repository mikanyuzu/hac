/**
 * [module]
 * ReserveDataRegistByHub.java
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
import org.tsrvfw.common.util.DateUtils;
import org.tsrvfw.common.util.LogicUtils;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.dao.AbstractDao;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.service.AbstractService;

/**
 * 予約情報登録クラス
 * 
 * @author sysusr1
 *
 */
public class ReserveDataRegistByHub extends AbstractService {

	/** 予約情報Dao */
	private AbstractDao reserveDao;

	/**
	 * 予約情報登録処理実行
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		// 店舗管理No
		String hubMngNo = LogicUtils.getMapValueToString(inputData, ComponentCommonConst.KEY_USRINFO_HUB_MNG_NO);
		// 存在チェック
		if (!LogicUtils.isNotEmptyString(hubMngNo)) {
			throw new HACBusinessException(
					this.getClass().getName() + ":00001", "", "店舗管理No");
		}
		String nowYyyyMm = DateUtils.getFormatDate(DateUtils.getSystemDate(), "yyyyMM");
		inputData.put("now_yyyy_mm", nowYyyyMm);
		// 予約管理Noを採番する
		Map<String, Object> resultDataMap = reserveDao.executeSelect(inputData, "selectCountReserveByHubMngNo");
		List<Map<String, Object>> resultList = (List<Map<String, Object>>)resultDataMap.get("select_result");
		log.debug("取得データ：" + resultList);
		int count = 0;
		for(Map<String, Object> data : resultList){
			count = ((Long) data.get("cnt")).intValue();
			log.debug("採番済み予約台帳No:" + count);
		}
		String reserveLedgerNo = nowYyyyMm + String.format("%1$09d", count + 1);
		log.debug("採番した予約台帳No:" + reserveLedgerNo);
		
		// 店舗別予約管理登録
		inputData.put("reserve_ledger_no", reserveLedgerNo);
		reserveDao.executeInsert(inputData, "insertReserveMngByHubMngNo");
		
		// 予約詳細登録
		String usedMenu = LogicUtils.getMapValueToString(inputData, "used_menu");
		if (!LogicUtils.isNotEmptyString(usedMenu)){
			usedMenu = "99999";
		}
		inputData.put("used_menu", usedMenu);
		String unitPrice = LogicUtils.getMapValueToString(inputData, "unit_price");
		if (!LogicUtils.isNotEmptyString(unitPrice)){
			unitPrice = "0";
		}
		inputData.put("unit_price", unitPrice);
		reserveDao.executeInsert(inputData, "insertReserveDetailByHubMngNo");

		// 結果Map作成
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(ActionCommonConst.RESULT_CODE,
				ActionCommonConst.RESULT_SUCCESS);
		return resultMap;
	}

	/**
	 * 予約情報Daoインスタンス設定
	 * 
	 * @param dao
	 *            ユーザ情報Dao
	 */
	public void setReserveDao(AbstractDao dao) {
		this.reserveDao = dao;
	}

}
