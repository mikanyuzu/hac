/**
 * [module]
 * TransitionAction.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.tsrvfw.action.impl;

import java.util.HashMap;
import java.util.Map;

import org.tsrvfw.action.AbstractAction;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.model.AbstractModel;

/**
 * 画面遷移Actionクラス
 * 
 * @author tsubaki
 * 
 */
public class TransitionAction extends AbstractAction {

	/** シリアルID */
	private static final long serialVersionUID = 1L;

	/**
	 * 画面遷移実行
	 * 
	 * @param model
	 *            各画面モデルクラス
	 * @return 処理結果
	 * @throws TsrvfwBusinessException
	 *             業務エラーが発生した場合
	 * @throws TsrvfwSystemException
	 *             想定外エラーが発生した場合
	 */
	@Override
	public String executeBusinessAction(AbstractModel model)
			throws TsrvfwBusinessException, TsrvfwSystemException {
		return "success";
	}

	/**
	 * 業務エラー発生時処理実行
	 * 
	 * @return 処理結果
	 * @throws TsrvfwSystemException
	 *             想定外エラーが発生した場合
	 */
	@Override
	public Map<String, Object> executeBusinessException()
			throws TsrvfwSystemException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put(ActionCommonConst.RESULT_CODE,
				ActionCommonConst.BUSINESS_ERR);
		resultMap.put(ActionCommonConst.BIS_ERR_MESSAGE, "画面遷移に失敗しました。");
		return resultMap;
	}

	/**
	 * 想定外エラー発生時処理実行
	 * 
	 * @throws Exception
	 *             システムエラーが発生した場合
	 */
	@Override
	public void executeSystemException() throws Exception {
	}

}
