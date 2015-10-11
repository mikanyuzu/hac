/**
 * [module]
 * RegistCustmer.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.tsrvfw.common.util.LogicUtils;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.dao.AbstractDao;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.service.AbstractService;

/**
 * クラス
 *
 * @author tsubaki
 *
 */
public class RegistCustmer extends AbstractService {

	/** 業務処理Dao　顧客管理 */
	private AbstractDao custmerDao;
	
	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		
		// 顧客管理Noを取得する
		String hubMngNo = LogicUtils.getMapValueToString(inputData, "hub_mng_no");
		if (!LogicUtils.isNotEmptyString(hubMngNo)){
			throw new TsrvfwBusinessException("", "", null);
		}
		String hubMngDist = hubMngNo.substring(0, 3);
		inputData.put("hub_mng_dist", hubMngDist + "C");
		Map<String, Object> cstmerMngNoResultMap = custmerDao.executeSelect(inputData, "selectCustmerMngNo");
		List<Map<String, Object>> selectResultList = (List<Map<String, Object>>)cstmerMngNoResultMap.get("select_result");
		for (Map<String, Object> dataMap : selectResultList){
			inputData.put("custmer_mng_no", (String)dataMap.get("custmer_mng_no"));
		}
		custmerDao.executeInsert(inputData, "insertCustmerMst");
		custmerDao.executeInsert(inputData, "insertCustmerDetail");
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(ActionCommonConst.RESULT_CODE, ActionCommonConst.RESULT_SUCCESS);
		resultMap.put("regist_data", inputData);
		return resultMap;
	}
	
	/**
	 * 業務処理Dao　顧客管理 インスタンス設定
	 * @param dao 業務処理Dao　顧客管理
	 */
	public void setCustmerDao(AbstractDao dao) {
		this.custmerDao = dao;
	}

}

