/**
 * [module]
 * AbstractAction.java
 *
 * Copyright (c) 2014 M.Tsubaki
 * This software is released under the MIT License.
 * http://opensource.org/licenses/mit-license.php
 */
package org.tsrvfw.action;

import java.text.MessageFormat;
import java.util.Map;

import org.apache.log4j.Logger;
import org.tsrvfw.common.logger.CommonLogger;
import org.tsrvfw.common.message.MessageConfigManager;
import org.tsrvfw.common.util.LogicUtils;
import org.tsrvfw.constant.ActionCommonConst;
import org.tsrvfw.constant.CommonConst;
import org.tsrvfw.exception.TsrvfwBusinessException;
import org.tsrvfw.exception.TsrvfwSystemException;
import org.tsrvfw.model.AbstractModel;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * Action基底クラス
 * 
 * @author tsubaki
 * 
 */
public abstract class AbstractAction extends ActionSupport implements
		ModelDriven<Object> {

	/** シリアルID */
	private static final long serialVersionUID = -2006464293038896703L;

	/** ロガー */
	protected Logger log = CommonLogger.getLogger(this.getClass().getName());

	/** 各画面モデル */
	private AbstractModel model;

	/** 画面表示部品コード */
	private String displayCode;
	
	/** 追加画面表示コード */
	private String alphaDisplayCode;
	
	/** 業務区分 */
	private String workType;

	/**
	 * 業務区分設定
	 * @param workType 業務区分
	 */
	public void setWorkType(String workType) {
		this.workType = workType;
	}

	/**
	 * モデルクラス取得
	 * 
	 * @return 各画面モデルクラス
	 */
	public AbstractModel getModel() {
		return model;
	}

	/**
	 * モデルクラスインスタンス設定
	 * 
	 * @param model
	 *            各画面モデルクラス
	 */
	public void setModel(AbstractModel model) {
		log.debug(model.getClass());
		this.model = model;
	}

	/***
	 * Action実行
	 * 
	 * @return 処理結果
	 */
	public String execute() throws Exception {
		log.debug("start");
		String actionResult = "";
		try {
			// メッセージクリア
			model.setAppMessage("");
			model.setIsError(false);
			model.setErrType(CommonConst.ERROR_TYPE_NO);
			
			// 業務処理実行
			actionResult = executeBusinessAction(model);
			
			// 画面表示コード設定
			this.setDisplayCode();
			
			// 業務区分に指定があれば設定する
			this.setWorkType();
		}
		// 業務エラー発生時
		catch (TsrvfwBusinessException e) {
			Map<String, Object> eResult = executeBusinessException();
			String resultCode = eResult.get(ActionCommonConst.RESULT_CODE) != null ? (String) eResult
					.get(ActionCommonConst.RESULT_CODE)
					: ActionCommonConst.BUSINESS_ERR;
			String innerCode = e.getInnerCode();
			String message = MessageConfigManager.getViewMessageFromInnerCode(innerCode);
			String editedMessage = MessageFormat.format(message, e.getParams());
			model.setIsError(true);
			model.setErrType(CommonConst.ERROR_TYPE_E);
			model.setAppMessage(editedMessage);
			log.warn(message);
			log.warn(e);
			actionResult = resultCode;
		}
		// 想定内システムエラー発生時
		catch (TsrvfwSystemException e) {
			log.error(e);
			e.printStackTrace();
			executeSystemException();
			actionResult = ActionCommonConst.SYSTEM_ERR;
		}
		// 想定外システムエラー発生時
		catch (Exception e) {
			log.error(e);
			e.printStackTrace();
			executeSystemException();
			actionResult = ActionCommonConst.SYSTEM_ERR;
		}
		log.debug("end");
		return actionResult;
	}
	
	/**
	 * 画面表示コード設定
	 */
	private void setDisplayCode(){
		// 画面表示コード設定
		if (LogicUtils.isNotEmptyString(this.alphaDisplayCode)){
			String[] str = new String[2];
			if ("leave".equals(this.displayCode)){
				str[0] = model.getDisplayCode();
			}
			else {
				str[0] = this.displayCode;
			}
			str[1] = this.alphaDisplayCode;
			model.setAlphaDisplayCode(this.alphaDisplayCode);
		}
		else {
			model.setDisplayCode(this.displayCode);
		}
	}
	
	/**
	 * 業務区分を設定する
	 */
	private void setWorkType(){
		if (LogicUtils.isNotEmptyString(this.workType)) {
			this.model.setWorkType(this.workType);
		}
	}

	/**
	 * 画面部品表示コード取得
	 * @return 画面部品表示コード
	 */
	public String getDisplayCode() {
		return displayCode;
	}

	/**
	 * 画面部品表示コード設定
	 * @param displayCode 画面部品表示コード
	 */
	public void setDisplayCode(String displayCode) {
		this.displayCode = displayCode;
	}
	
	/**
	 * 追加画面表示コード取得
	 * @return 追加画面表示コード
	 */
	public String getAlphaDisplayCode() {
		return alphaDisplayCode;
	}

	/**
	 * 追加画面表示コード設定
	 * @param alphaDisplayCode 追加画面表示コード
	 */
	public void setAlphaDisplayCode(String alphaDisplayCode) {
		this.alphaDisplayCode = alphaDisplayCode;
	}

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
	public abstract String executeBusinessAction(AbstractModel model)
			throws TsrvfwBusinessException, TsrvfwSystemException;

	/**
	 * 業務エラー発生時処理実行
	 * 
	 * @return 処理結果
	 * @throws TsrvfwSystemException
	 *             想定外エラーが発生した場合
	 */
	public abstract Map<String, Object> executeBusinessException()
			throws TsrvfwSystemException;

	/**
	 * 想定外エラー発生時処理実行
	 * 
	 * @throws Exception
	 *             システムエラーが発生した場合
	 */
	public abstract void executeSystemException() throws Exception;
}
