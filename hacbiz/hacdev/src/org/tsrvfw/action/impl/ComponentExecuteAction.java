/**
 * [module]
 * ComponentExecuteAction.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.tsrvfw.action.impl;

import java.util.Map;

import org.tsrvfw.action.AbstractAction;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.facade.AbstractFacade;
import org.tsrvfw.model.AbstractModel;

/***
 * Component実行Actionクラス
 * 
 * @author tsubaki
 * 
 */
public class ComponentExecuteAction extends AbstractAction {

	/** 業務Facade */
	private AbstractFacade facade;

	/** シリアルID */
	private static final long serialVersionUID = 880608590274546222L;

	/**
	 * 各業務処理実行
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
		
		// 個別業務処理実行
		Map<String, Object> facadeResult = facade.execute(model);
		// 処理結果を成功で初期化
		String actionResult = (String) facadeResult.get(ActionCommonConst.RESULT_CODE);
		
		/*// 業務エラーであった場合
		if (facadeResult.get(ActionCommonConst.RESULT_CODE).equals(ActionCommonConst.BUSINESS_ERR)) {
			throw new TsrvfwBusinessException("", "");
		}*/
		return actionResult;
	}

	/**
	 * 業務Facadeインスタンス設定
	 * 
	 * @param facade
	 */
	public void setFacade(AbstractFacade facade) {
		this.facade = facade;
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
		return facade.executeBusinessException();
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
