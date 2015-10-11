/**
 * [module]
 * BasicDao.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.dao.impl;

import java.util.List;
import java.util.Map;

import org.tsrvfw.dao.AbstractDao;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * 基本Daoクラス
 * @author sysusr1
 *
 */
public class BasicDao extends AbstractDao{

	/**
	 * コンストラクタ
	 * @param sqlMapClient
	 */
	public BasicDao(SqlMapClient sqlMapClient){
		setSqlMapClient(sqlMapClient);
	}
	
	/**
	 * 検索処理
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected List<Map<String, Object>> select(Map<String, Object> inputMap,
			String target) {
		return (List<Map<String, Object>>)getSqlMapClientTemplate().queryForList(target, inputMap);
	}

	/**
	 * 登録処理
	 */
	@Override
	protected void insert(Map<String, Object> inputMap, String target) {
		getSqlMapClientTemplate().insert(target, inputMap);
	}

	/**
	 * 更新処理
	 */
	@Override
	protected void update(Map<String, Object> inputMap, String target) {
		getSqlMapClientTemplate().update(target, inputMap);
	}

}
