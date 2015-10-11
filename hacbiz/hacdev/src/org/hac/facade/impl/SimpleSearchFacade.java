/**
 * [module]
 * SimpleSearchFacade.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.hac.facade.impl;

import java.util.HashMap;
import java.util.Map;

import org.hac.common.ComponentCommonConst;
import org.hac.exception.HACBusinessException;
import org.hac.model.impl.CommonModel;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.facade.AbstractFacade;
import org.tsrvfw.model.AbstractModel;
import org.tsrvfw.service.AbstractService;

/**
 * 簡易検索Facadeクラス
 * 
 * @author tsubaki
 * 
 */
public class SimpleSearchFacade extends AbstractFacade {

	/** 入力値チェックコンポーネント */
	private AbstractService InputRequireCheck;
	
	/**
	 * 簡易検索実行業務処理
	 */
	@Override
	protected Map<String, Object> executeBusiness(AbstractModel model)
			throws TsrvfwSystemException, TsrvfwBusinessException {

		// 画面入力値を取得する
		CommonModel inputModel = (CommonModel)model;
		// 入力値をMapに詰める
		Map<String, Object> inputData = new HashMap<String, Object>();
		Map<String, Object> inputDatas = new HashMap<String, Object>();
		inputDatas.put("SimpleSearchName", inputModel.getSimpleSearchName());
		inputDatas.put("SimpleSearchTel", inputModel.getSimpleSearchTel());
		inputData.put(ComponentCommonConst.KEY_INPUT_CHECK_DATA, inputDatas);
		inputData.put(ComponentCommonConst.KEY_INPUT_CHECK_CONDITION, ComponentCommonConst.KEY_INPUT_CHECK_CONDITION_OR);
		
		// 入力値チェック実施
		Map<String, Object> checkResult = InputRequireCheck.execute(inputData);
		// チェックNGの場合
		if (ComponentCommonConst.KEY_INPUT_CHECK_NG.equals(checkResult.get(ComponentCommonConst.KEY_INPUT_CHECK_RESULT))){
			throw new HACBusinessException(this.getClass().getName() + ":00001", "", null);
		}
		
		// 処理結果Map生成
		Map<String, Object> facadeResultMap = new HashMap<String, Object>();
		facadeResultMap.put(ActionCommonConst.RESULT_CODE,
				ActionCommonConst.RESULT_SUCCESS);
		return facadeResultMap;
	}

	/**
	 * 業務エラー処理
	 */
	@Override
	public Map<String, Object> executeBusinessException()
			throws TsrvfwSystemException {
		// 処理結果Map生成
		Map<String, Object> facadeResultMap = new HashMap<String, Object>();
		facadeResultMap.put(ActionCommonConst.RESULT_CODE,
				ActionCommonConst.BUSINESS_ERR);
		return facadeResultMap;
	}
	
	/**
	 * 業務処理コンポーネント　Email送信インスタンス設定
	 * 
	 * @param emailSend
	 *            業務処理コンポーネント　Email送信インスタンス設定
	 */
	public void setInputRequireCheck(AbstractService service) {
		this.InputRequireCheck = service;
	}

}
