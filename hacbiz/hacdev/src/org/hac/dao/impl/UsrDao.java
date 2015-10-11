/**
 * [module]
 * Usr.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.dao.impl;

import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * クラス
 * @author sysusr1
 *
 */
public class UsrDao extends BasicDao {

	public UsrDao(SqlMapClient sqlMapClient) {
		super(sqlMapClient);
	}

}
