/**
 * [module]
 * EntranceLogoutFacade.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.facade.impl;

import java.util.HashMap;
import java.util.Map;

import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.facade.AbstractFacade;
import org.tsrvfw.model.AbstractModel;

/**
 * ログアウト処理Facadeクラス
 * 
 * @author tsubaki
 * 
 */
public class EntranceLogoutFacade extends AbstractFacade {

	/**
	 * 
	 */
	@Override
	protected Map<String, Object> executeBusiness(AbstractModel model)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		
		
		// 処理結果Map生成
		Map<String, Object> facadeResultMap = new HashMap<String, Object>();
		facadeResultMap.put(ActionCommonConst.RESULT_CODE,
				ActionCommonConst.RESULT_SUCCESS);
		return facadeResultMap;
	}

	/**
	 * 
	 */
	@Override
	public Map<String, Object> executeBusinessException()
			throws TsrvfwSystemException {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

}
