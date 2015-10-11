/**
 * [module]
 * RequiredCheck.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.hac.exception.HACBusinessException;
import org.hac.exception.HACSystemException;
import org.tsrvfw.common.util.LogicUtils;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.service.AbstractService;

/**
 * 必須チェッククラス
 *
 * @author tsubaki
 *
 */
public class RequireCheck extends AbstractService {

	/**
	 * 必須チェック処理実行
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		
		// チェック対象データのチェック
		if (!LogicUtils.isNotEmptyMap(inputData)){
			throw new HACSystemException("入力チェック対象データが存在しません。");
		}
		// 入力情報の取得
		for(Map.Entry<String, ?> e : inputData.entrySet()) {
			Map<String, Object> valueMap = (Map<String, Object>)inputData.get(e.getKey());
			// チェック対象データのチェック
			if (!LogicUtils.isNotEmptyMap(valueMap)){
				throw new HACSystemException("データ形式が不正です。");
			}
			String data = LogicUtils.getMapValueToString(valueMap, "data");
			if (!LogicUtils.isNotEmptyString(data)){
				throw new HACBusinessException(this.getClass().getName() + ":00001", "", (String[])valueMap.get("name"));
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(ActionCommonConst.RESULT_CODE, ActionCommonConst.RESULT_SUCCESS);
		return resultMap;
	}

}

