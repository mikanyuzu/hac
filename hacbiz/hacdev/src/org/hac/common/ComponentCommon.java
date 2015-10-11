/**
 * [module]
 * ComponentCommon.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.common;

import java.util.HashMap;
import java.util.Map;


/**
 * クラス
 *
 * @author tsubaki
 *
 */
public class ComponentCommon {

	/**
	 * 入力データを項目Mapデータに整形する
	 * @param targetData 入力値
	 * @param key Mapキー
	 * @param name 名称
	 * @return 項目Map
	 */
	public static Map<String, Object> editDataMap(String targetData, String length, String type, String key, String... names){
		Map<String, Object> editedMap = new HashMap<String, Object>();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("data", targetData);
		dataMap.put("name", names);
		dataMap.put("length", length);
		dataMap.put("type", type);
		editedMap.put(key, dataMap);
		return editedMap;
	}
	
	/**
	 * 隠蔽コンストラクタ
	 */
	private ComponentCommon(){
		// インスタンス生成禁止
	}
}

