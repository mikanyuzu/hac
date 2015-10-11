/**
 * [module]
 * FormatCheck.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.CharUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.hac.common.ComponentCommonConst;
import org.hac.exception.HACBusinessException;
import org.hac.exception.HACSystemException;
import org.tsrvfw.common.util.LogicUtils;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.service.AbstractService;

/**
 * クラス
 * 
 * @author tsubaki
 * 
 */
public class FormatCheck extends AbstractService {
	
	/**
	 * 形式チェック処理実行
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected Map<String, Object> executeService(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {

		// チェック対象データのチェック
		if (!LogicUtils.isNotEmptyMap(inputData)) {
			throw new HACSystemException("入力チェック対象データが存在しません。");
		}
		// 入力情報の取得
		for (Map.Entry<String, ?> e : inputData.entrySet()) {
			Map<String, Object> valueMap = (Map<String, Object>) inputData
					.get(e.getKey());
			// チェック対象データのチェック
			if (!LogicUtils.isNotEmptyMap(valueMap)) {
				throw new HACSystemException("データ形式が不正です。データなし。");
			}
			String data = LogicUtils.getMapValueToString(valueMap, "data");
			String type = LogicUtils.getMapValueToString(valueMap, "type");
			if (!NumberUtils.isNumber(type)) {
				throw new HACSystemException("データ形式が不正です。typeが数値でない。");
			}
			if (LogicUtils.isNotEmptyString(data)) {
				// 数値の場合
				if (2 == Integer.parseInt(type)){
					if (!NumberUtils.isNumber(data)){
						throw new HACBusinessException(this.getClass().getName() + ":00001", "", (String[]) valueMap.get("name"));
					}
				}
				// 英数の場合
				if (3 == Integer.parseInt(type)) {
					for(char c : data.toCharArray()){
						if (!CharUtils.isAsciiAlphanumeric(c)){
							throw new HACBusinessException(this.getClass().getName() + ":00002", "", (String[]) valueMap.get("name"));
						}
					}
				}
				// メールアドレスの場合
				if (4 == Integer.parseInt(type)) {
					Pattern ptn = Pattern.compile(ComponentCommonConst.REGEX_PATTERN_EMAIL);
					Matcher mc = ptn.matcher(data);
					if (!mc.matches()) {
						throw new HACBusinessException(this.getClass().getName() + ":00002", "", (String[]) valueMap.get("name"));
					}
				}
			}
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(ActionCommonConst.RESULT_CODE, ActionCommonConst.RESULT_SUCCESS);
		return resultMap;
	}
}
