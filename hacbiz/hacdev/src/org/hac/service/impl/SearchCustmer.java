/**
 * [module]
 * SearchCustmer.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class SearchCustmer extends AbstractService {

	/** 業務処理Dao　顧客管理 */
	private AbstractDao custmerDao;
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		
		// 顧客マスタ検索実行
		Map<String, Object> selectCustmerOfHubMngNoResultMap = custmerDao.executeSelect(inputData, "selectCustmerOfHubMngNo");
		List<Map<String, Object>> resultDataList = (List<Map<String, Object>>)selectCustmerOfHubMngNoResultMap.get("select_result");
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("select_result", resultDataList);
		resultMap.put(ActionCommonConst.RESULT_CODE, ActionCommonConst.RESULT_SUCCESS);
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

