/**
 * [module]
 * BasicRemoteComponent.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.remote.impl;

import java.util.Map;

import org.hac.remote.AbstractHttpRemoteCall;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;

/**
 * リモート呼び出し基本処理クラス
 * @author sysusr1
 *
 */
public class BasicRemoteComponent extends AbstractHttpRemoteCall{

	/**
	 * リモートコンポーネント実行
	 */
	@Override
	protected Map<String, Object> executeBusiness(Map<String, Object> inputData)
			throws TsrvfwSystemException, TsrvfwBusinessException {
		log.info("----リモート呼び出し開始-----");
		return service.execute(inputData);
	}
}
