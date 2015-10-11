/**
 * [module]
 * OrgMstDao.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * クラス
 *
 * @author tsubaki
 *
 */
public class OrgDao extends BasicDao {

	/**
	 * コンストラクタ
	 * @param sqlMapClient
	 */
	public OrgDao(SqlMapClient sqlMapClient) {
		super(sqlMapClient);
	}
}

