/**
 * [module]
 * CorpMasterRegist.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.dao.AbstractDao;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.service.AbstractService;

/**
 * 会社情報マスタ登録処理クラス
 * 
 * @author sysusr1
 *
 */
public class CorpMasterRegist extends AbstractService {

	/** 会社情報Dao */
	private AbstractDao orgDao;
	
	/**
	 * 会社情報Daoインスタンス設定
	 * @param orgMst 会社情報Dao
	 */
	public void setOrgDao(AbstractDao dao) {
		this.orgDao = dao;
	}
	
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		
		// 結果Map作成
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(ActionCommonConst.RESULT_CODE, ActionCommonConst.RESULT_SUCCESS);
		return resultMap;
	}

}
