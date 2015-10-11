/**
 * [module]
 * HttpRemoteCallInterface.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.remote;

import java.util.Map;

/**
 * リモート呼び出し処理インターフェース
 * @author sysusr1
 *
 */
public interface HttpRemoteCallInterface {

	/**
	 * 業務処理実行
	 * 
	 * @param inputData 入力データ
	 * @return 処理結果
	 */
	public Map<String, Object> execute(Map<String, Object> inputData);
}
