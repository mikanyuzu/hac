/**
 * [module]
 * CustmerDao.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.dao.impl;

import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * クラス
 *
 * @author tsubaki
 *
 */
public class CustmerDao extends BasicDao {

	/**
	 * コンストラクタ
	 * @param sqlMapClient
	 */
	public CustmerDao(SqlMapClient sqlMapClient) {
		super(sqlMapClient);
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected List<Map<String, Object>> select(Map<String, Object> inputMap,
			String target) {
		// 検索条件保持オブジェクト
		Object conditions = inputMap;
		// 検索条件オブジェクトに指定がある場合
		if (inputMap.containsKey("conditionDtoClass")){
			conditions = inputMap.get("conditionDtoClass");
		}
		return (List<Map<String, Object>>)getSqlMapClientTemplate().queryForList(target, conditions);
	}
}

