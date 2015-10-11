/**
 * [module]
 * InputRequireCheck.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.hac.common.ComponentCommonConst;
import org.hac.exception.HACSystemException;
import org.tsrvfw.common.util.LogicUtils;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.service.AbstractService;

/**
 * 入力チェッククラス
 * 
 * @author tsubaki
 * 
 */
public class InputRequireCheck extends AbstractService {

	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwBusinessException, TsrvfwSystemException {

		// チェック対象データを取得
		Map<String, Object> checkTargetDatas = (Map<String, Object>) inputData.get(ComponentCommonConst.KEY_INPUT_CHECK_DATA);
		String checkCondition = (String) inputData.get(ComponentCommonConst.KEY_INPUT_CHECK_CONDITION);

		// チェック対象データの存在チェック
		// データ
		if (!LogicUtils.isNotEmptyMap(checkTargetDatas)) {
			throw new HACSystemException("入力チェック対象データが存在しません。");
		}
		// チェック条件
		if (!LogicUtils.isNotEmptyString(checkCondition)) {
			throw new HACSystemException("入力チェック条件が存在しません。");
		}

		boolean checkresult = false;
		// AND条件の場合
		if (ComponentCommonConst.KEY_INPUT_CHECK_CONDITION_AND.equals(checkCondition)){
			checkresult = this.checkAnd(checkTargetDatas);
		}
		// OR条件の場合
		if (ComponentCommonConst.KEY_INPUT_CHECK_CONDITION_OR.equals(checkCondition)){
			checkresult = this.checkOr(checkTargetDatas);
		}

		// 結果Map作成
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(ComponentCommonConst.KEY_INPUT_CHECK_RESULT, checkresult ? ComponentCommonConst.KEY_INPUT_CHECK_OK :ComponentCommonConst.KEY_INPUT_CHECK_NG);
		return resultMap;
	}
	
	/**
	 * すべて存在するかチェックを行う
	 * @param checkTargetDatas
	 * @return すべて存在：true
	 */
	private boolean checkAnd(Map<String, Object> checkTargetDatas) {
		boolean result = true;
		for(Map.Entry<String, Object> entry : checkTargetDatas.entrySet()){
			if (!LogicUtils.isNotEmptyString((String)entry.getValue())){
				result = false;
				break;
			}
		}
		return result;
	}

	/**
	 * いづれか存在するかチェックを行う
	 * @param checkTargetDatas
	 * @return いづれか存在する：true
	 */
	private boolean checkOr(Map<String, Object> checkTargetDatas) {
		boolean result = false;
		for(Map.Entry<String, Object> entry : checkTargetDatas.entrySet()){
			if (LogicUtils.isNotEmptyString((String)entry.getValue())){
				result = true;
				break;
			}
		}
		return result;
	}

}
